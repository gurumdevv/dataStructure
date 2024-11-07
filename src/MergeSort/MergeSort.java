package MergeSort;

import java.util.Scanner;

public class MergeSort {
    static int[] buffer;

    static void __mergeSort(int[] a, int left, int right) {
        if (left < right) {
            int i;
            int center = (left + right) / 2;
            int pointer = 0;
            int j = 0;
            int originIndex = left;

            __mergeSort(a, left, center);
            __mergeSort(a, center + 1, right);

            for (i = left; i <= center; i++) {
                buffer[pointer++] = a[i];
            }

            /*
                i == center + 1 -> i <= right 의미: center + 1 ~ right
                j == 0, pointer == center - left + 1 ->  j < pointer 의미: left ~ center (buffer의 모든 요소)
                j < pointer 인 이유: buffer의 저장된 갯수가 center - left + 1  일 때 Max Index는 -1 한 값인 center - left 이므로 =(등호)가 포함 안 됨
            */
            while (i <= right && j < pointer) {
                a[originIndex++] = (buffer[j] <= a[i]) ? buffer[j++] : a[i++];
            }

            while (j < pointer) {
                a[originIndex++] = buffer[j++];
            }
        }
    }

    static void mergeSort(int[] a, int n) {
        buffer = new int[n];

        __mergeSort(a, 0, n - 1);

        buffer = null;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("병합 정렬");
        System.out.print("요솟수: ");
        int size = stdIn.nextInt();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("x[" + i + "]: ");
            array[i] = stdIn.nextInt();
        }

        mergeSort(array, size);

        System.out.println("오름차순으로 정렬 완료!");
        for (int i = 0; i < size; i++) {
            System.out.println("x[" + i + "]=" + array[i]);
        }
    }
}
