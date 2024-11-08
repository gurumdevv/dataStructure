package ShellSort;

import java.util.Scanner;

public class ShellSort {

    static void shellSort(int[] a, int n) {
        for (int h = n / 2; h > 0; h /= 2) {
            for (int i = h; i < n; i++) {
                int j;
                int temp = a[i]; //Insertion Sort
                for (j = i - h; j >= 0 && a[j] > temp; j -= h) {
                    a[j + h] = a[j]; //Insertion Sort
                }
                a[j + h] = temp; //Insertion Sort
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("셸 정렬 v.1");
        System.out.print("요솟수: ");
        int size = stdIn.nextInt();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("x[" + i + "]: ");
            array[i] = stdIn.nextInt();
        }

        shellSort(array, size);

        System.out.println("오름차순으로 정렬 완료!");
        for (int i = 0; i < size; i++) {
            System.out.println("x[" + i + "]=" + array[i]);
        }
    }
}
