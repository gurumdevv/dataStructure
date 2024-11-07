package BubbleSort;

import java.util.Scanner;

class BubbleSort {

    static void swap(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

    static void bubbleSort(int[] array, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j > i; j--) {
                if (array[j - 1] > array[j]) swap(array, j - 1, j);
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("버블 정렬 [V.1]");
        System.out.print("요솟수: ");
        int size = stdIn.nextInt();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("x[" + i + "]: ");
            array[i] = stdIn.nextInt();
        }

        bubbleSort(array, size);

        System.out.println("오름차순으로 정렬 완료!");
        for (int i = 0; i < size; i++) {
            System.out.println("x[" + i + "]: " + array[i]);
        }
    }
}