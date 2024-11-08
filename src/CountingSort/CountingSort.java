package CountingSort;

import java.util.Scanner;

public class CountingSort {

    static void countingSort(int[] a, int n, int max) {
        int[] cumulativeFrequencyArray = new int[max + 1]; //도수 분포표로 사용한 후 누적 도수 분포표로 사용함
        int[] buffer = new int[n];

        for (int i = 0; i < n; i++) cumulativeFrequencyArray[a[i]]++;
        for (int i = 1; i <= max; i++) cumulativeFrequencyArray[i] += cumulativeFrequencyArray[i - 1];
        for (int i = n - 1; i >= 0; i--) buffer[--cumulativeFrequencyArray[a[i]]] = a[i];
        System.arraycopy(buffer, 0, a, 0, n);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("도수 정렬");
        System.out.print("요솟수: ");
        int size = stdIn.nextInt();
        int[] array = new int[size];

        int max = 0;
        for (int i = 0; i < size; i++) {
            System.out.print("x[" + i + "]: ");
            array[i] = stdIn.nextInt();
            max = Math.max(max, array[i]);
        }

        countingSort(array, size, max);

        System.out.println("오름차순으로 정렬 완료!");
        for (int i = 0; i < size; i++) {
            System.out.println("x[" + i + "]: " + array[i]);
        }
    }
}
