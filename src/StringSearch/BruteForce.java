package StringSearch;

import java.util.Scanner;

public class BruteForce {

    static Scanner sc = new Scanner(System.in);

    static int bruteForceMatch(String text, String pattern) {
        int textPointer = 0;
        int patternPointer = 0;

        while (textPointer != text.length() && patternPointer != pattern.length()) {
            if (text.charAt(textPointer) == pattern.charAt(patternPointer)) {
                textPointer++;
                patternPointer++;
            } else {
                textPointer = textPointer - patternPointer + 1; //원복 후 다음 위치로 이동
                patternPointer = 0;
            }
        }

        if (patternPointer == pattern.length()) { //검색 성공
            return textPointer - patternPointer;
        }
        return -1; //검색 실패
    }

    public static void main(String[] args) {
        System.out.print("텍스트: ");
        String s1 = sc.next();

        System.out.print("패 턴: ");
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
