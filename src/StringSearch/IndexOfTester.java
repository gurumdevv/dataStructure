package StringSearch;

import java.util.Scanner;

class IndexOfTester {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("텍스트: ");
        String text = sc.next();

        System.out.print("패 턴: ");
        String pattern = sc.next();

        int index1 = text.indexOf(pattern);
        int index2 = text.lastIndexOf(pattern);

        if (index1 == -1) {
            System.out.println("텍스트 안에 패턴이 없습니다.");
        } else {
            int length1 = 0;
            for (int i = 0; i < index1; i++) {
                length1 += text.substring(i, i + 1).getBytes().length;
            }
            length1 += pattern.length();

            int length2 = 0;
            for (int i = 0; i < index2; i++) {
                length2 += text.substring(i, i + 1).getBytes().length;
            }
            length2 = text.substring(0, index2).length();
            length2 += pattern.length();

            System.out.println("텍스트: " + text);
            System.out.printf(String.format("패 턴: %%%ds\n", length1), pattern);
            System.out.println("텍스트: " + text);
            System.out.printf(String.format("패 턴: %%%ds\n", length2), pattern);
        }
    }
}
