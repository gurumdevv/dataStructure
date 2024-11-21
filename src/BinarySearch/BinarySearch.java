package BinarySearch;

import java.util.Scanner;

public class BinarySearch {

    static int binarySearch(int[] a, int n, int key) {
        int left = 0;
        int right = n - 1;

        do {
            int mid = (left + right) / 2;
            if (a[mid] == key) return mid;
            else if (a[mid] < key) left = mid + 1;
            else right = mid - 1;
        } while (left <= right);

        return -1;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수: ");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        System.out.print("x[0]: ");
        x[0] = stdIn.nextInt();

        for (int i = 1; i < num; i++) {
            do {
                System.out.print("x[" + i + "]: ");
                x[i] = stdIn.nextInt();
            } while (x[i] < x[i - 1]);
        }

        System.out.print("검색할 값: ");
        int key = stdIn.nextInt();

        int result = binarySearch(x, num, key);

        if (result == -1) System.out.println(key + "를 발견하지 못했습니다.");
        else System.out.println(key + "는(은) x[" + result + "]에 있습니다.");
    }
}
