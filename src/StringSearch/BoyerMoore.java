package StringSearch;

import java.util.Scanner;

class BoyerMoore {

    static int boyerMooreMatch(String text, String pattern) {
        int pointer;
        int prePointer;
        int textLength = text.length();
        int patternLength = pattern.length();
        int[] skip = new int[Character.MAX_VALUE + 1];

        for (pointer = 0; pointer <= Character.MAX_VALUE; pointer++) {
            skip[pointer] = patternLength;
        }
        for (pointer = 0; pointer < patternLength - 1; pointer++) {
            skip[pattern.charAt(pointer)] = patternLength - pointer - 1;
        }

        while (pointer < textLength) {
            prePointer = patternLength - 1;

            while (text.charAt(pointer) == pattern.charAt(prePointer)) {
                if (prePointer == 0) return pointer;

                prePointer--;
                pointer--;
            }
            pointer += Math.max(skip[text.charAt(pointer)], patternLength - prePointer);
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("텍스트: ");
        String s1 = sc.next();

        System.out.print("패 턴: ");
        String s2 = sc.next();

        int index = boyerMooreMatch(s1, s2);
        if (index == -1) {
            System.out.println("텍스트에 패턴이 없습니다.");
        } else {
            int length = 0;
            for (int i = 0; i < index; i++) {
                length += s1.substring(i, i + 1).getBytes().length;
            }
            length += s2.length();

            System.out.println((index + 1) + "번째 문자부터 일치합니다.");
            System.out.println("텍스트: " + s1);
            System.out.printf(String.format("패 턴: %%%ds\n", length), s2);
        }
    }
}
