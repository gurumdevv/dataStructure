package QuickSort;

import java.util.Scanner;
import java.util.Stack;

public class QuickSortWithStack {

    static void swap(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

    static void quickSort(int[] a, int left, int right) {
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> rightStack = new Stack<>();

        leftStack.push(left);
        leftStack.push(right);

        while (!leftStack.isEmpty()) {
            int pointerLeft = left = leftStack.pop();
            int pointerRight = right = rightStack.pop();
            int pivot = a[(pointerLeft + pointerRight) / 2];

            do {
                while (a[pointerLeft] < pivot) pointerLeft++;
                while (a[pointerRight] > pivot) pointerRight--;
                if (pointerLeft <= pointerRight) swap(a, pointerLeft++, pointerRight--);
            } while (pointerLeft <= pointerRight);

            /* Replace recursion with a stack.
            if (left < pointerRight) quickSort(a, left, pointerRight);
            if (pointerLeft < right) quickSort(a, pointerLeft, right);
             */
            if (left < pointerRight) {
                leftStack.push(left);
                rightStack.push(pointerRight);
            }
            if (pointerLeft < right) {
                leftStack.push(pointerLeft);
                rightStack.push(right);
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("퀵 정렬");
        System.out.print("요솟수: ");
        int size = stdIn.nextInt();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("x[" + i + "]: ");
            array[i] = stdIn.nextInt();
        }

        quickSort(array, 0, size - 1);

        System.out.println("오름차순으로 정렬 완료!");
        for (int i = 0; i < size; i++) {
            System.out.println("x[" + i + "]=" + array[i]);
        }
    }
}
