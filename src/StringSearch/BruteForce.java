package StringSearch;

import java.util.Scanner;

public class BruteForce {

    static Scanner sc = new Scanner(System.in);

    static int bruteForceMatch(String text, String pattern) {
        int pointer = 0;
        int prePointer = 0;

        while (pointer != text.length() && prePointer != pattern.length()) {
            if (text.charAt(pointer) == pattern.charAt(prePointer)) {
                prePointer++;
                pointer++;
            } else {
                pointer = pointer - prePointer + 1;
                prePointer = 0;
            }
        }

        if (prePointer == pattern.length()) {
            return pointer - prePointer;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("텍스트: ");
        String s1 = sc.next();

        System.out.println("패 턴: ");
        String s2 = sc.next();

        int index = bruteForceMatch(s1, s2);
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
