package HeapSort;

import java.util.Scanner;

class HeapSort {

    static void swap(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

    static void downHeap(int[] a, int start, int end) {
        int temp = a[start];
        int child;
        int parent;

        /*
            parent < (end + 1) /2 자식을 가지고 있는 노드인지 검사
            (end + 1) /2 :  비리프 노드의 마지막 인덱스보다 하나 큰 값, 마지막 비리프 노드 이후는 모두 리프 노드이기 때문에 자식이 존재하지 않음
         */
        for (parent = start; parent < (end + 1) / 2; parent = child) {
            int leftChild = parent * 2 + 1;
            int rightChild = leftChild + 1;

            child = (rightChild <= end && a[rightChild] > a[leftChild]) ? rightChild : leftChild;

            if (temp >= a[child]) break;
            a[parent] = a[child];
        }
        a[parent] = temp;
    }

    static void heapSort(int[] a, int n) {
        for (int i = (n - 1) / 2; i >= 0; i--) {
            downHeap(a, i, n - 1);
        }
        for (int i = n - 1; i > 0; i--) {
            swap(a, 0, i);
            downHeap(a, 0, i - 1);
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("힙 정렬");
        System.out.print("요솟수: ");
        int size = stdIn.nextInt();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("x[" + i + "]: ");
            array[i] = stdIn.nextInt();
        }

        heapSort(array, size);

        System.out.println("오름차순으로 정렬 완료!");
        for (int i = 0; i < size; i++) {
            System.out.println("x[" + i + "]=" + array[i]);
        }
    }
}
