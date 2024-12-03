package StringSearch;

import java.util.Scanner;

class KMP {

    static int kmpMatch(String text, String pattern) {
        int pointer = 1; //text 커서
        int prePointer = 0; //pattern 커서
        int[] skip = new int[pattern.length() + 1]; //건너뛰기 표

        skip[pointer] = 0;
        while (pointer != pattern.length()) { //표 만들기
            if (pattern.charAt(pointer) == pattern.charAt(prePointer)) {
                skip[++pointer] = ++prePointer;
            } else if (prePointer == 0) {
                skip[++pointer] = prePointer;
            } else {
                prePointer = skip[prePointer];
            }
        }

        pointer = prePointer = 0;
        while (pointer != text.length() && prePointer != pattern.length()) { //검색
            if (text.charAt(pointer) == pattern.charAt(prePointer)) {
                pointer++;
                prePointer++;
            } else if (prePointer == 0) {
                pointer++;
            } else {
                prePointer = skip[prePointer];
            }
        }

        if (prePointer == pattern.length()) {
            return pointer - prePointer;
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("텍스트: ");
        String s1 = sc.next();

        System.out.print("패 턴: ");
        String s2 = sc.next();

        int index = kmpMatch(s1, s2);
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
