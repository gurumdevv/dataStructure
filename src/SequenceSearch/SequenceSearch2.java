package SequenceSearch;

import java.util.Scanner;

class SequenceSearch2 {

    private static int seqSearch(int[] a, int n, int key) {
        int i = 0;

        a[n] = key;

        while (true) {
            if (a[i] == key) return i;
            i++;
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수: ");
        int num = stdIn.nextInt();
        int[] x = new int[num + 1];

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        System.out.print("검색할 값: ");
        int key = stdIn.nextInt();

        int result = seqSearch(x, num, key);

        if (result == num) System.out.println(key + "를 발견하지 못했습니다.");
        else System.out.println(key + "는(은) x[" + result + "]에 있습니다.");
    }
}
