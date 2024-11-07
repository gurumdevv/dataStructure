package InsertionSort;

import java.util.Scanner;

class InsertionSort {

    static void insertionSort(int[] array, int n) {
        for (int i = 1; i < n; i++) {
            int j = i;
            int temp = array[i]; //정렬되지 않은 요소들 중 첫번째 요소 백업
            while (j > 0 && array[j - 1] > temp) {
                array[j] = array[j - 1];
                j--;
            } //정렬되지 않은 요소 중 첫번째 요소와 비교하여 큰 경우 배열을 하나씩 미뤄서 삽입
            array[j] = temp; //올바른 위치에 삽입되고 정렬이 완료됨
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("단순 삽입 정렬");
        System.out.print("요솟수: ");
        int size = stdIn.nextInt();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("x[" + i + "]: ");
            array[i] = stdIn.nextInt();
        }

        insertionSort(array, size);

        System.out.println("오름차순으로 정렬 완료!");
        for (int i = 0; i < size; i++) {
            System.out.println("x[" + i + "]: " + array[i]);
        }
    }
}
