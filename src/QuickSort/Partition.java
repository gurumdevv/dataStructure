package QuickSort;

import java.util.Scanner;

public class Partition {

    static void swap(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

    static void partition(int[] a, int n) {
        int left = 0;
        int right = n - 1;
        int pivot = a[n / 2];

        do {
            while (a[left] < pivot) left++;
            while (a[right] > pivot) right--;
            if (left <= right) swap(a, left++, right--);
        } while (left <= right);

        System.out.println("피벗값은 " + pivot + "입니다.");

        System.out.println("피벗 이하의 그룹");
        for (int i = 0; i <= left - 1; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        if (left > right + 1) {
            System.out.println("피벗과 같은 그룹");
            for (int i = right + 1; i <= left - 1; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }

        System.out.println("피벗 이상의 그룹");
        for (int i = right + 1; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("배열을 나눕니다.");
        System.out.print("요솟수: ");
        int size = stdIn.nextInt();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("x[" + i + "]: ");
            array[i] = stdIn.nextInt();
        }

        partition(array, size);
    }
}
