package MergeSort;

import java.util.Scanner;

public class MergeSort {
    static int[] temp;

    static void __mergeSort(int[] a, int left, int right) {
        if (left < right) {
            int i;
            int center = (left + right) / 2;
            int tempPointer = 0;
            int j = 0;
            int aPointer = left;

            //병합에 앞서서 왼쪽과 오른쪽 배열을 정렬
            __mergeSort(a, left, center);
            __mergeSort(a, center + 1, right);

            //원본 배열의 왼쪽 부분을 temp 배열로 복사
            for (i = left; i <= center; i++) {
                temp[tempPointer++] = a[i];
            }

            //처음 i는 center + 1로 증가하면서 원본 배열의 오른쪽 부분을 담당함
            //왼쪽 배열과 오른쪽 배열의 병합 과정
            while (i <= right && j < tempPointer) {
                a[aPointer++] = (temp[j] <= a[i]) ? temp[j++] : a[i++];
            }

            //temp 배열의 나머지를 원본 배열에 복사
            while (j < tempPointer) {
                a[aPointer++] = temp[j++];
            }
        }
    }

    static void mergeSort(int[] a, int n) {
        temp = new int[n];

        __mergeSort(a, 0, n - 1);

        temp = null;
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
