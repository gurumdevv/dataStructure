package Queue;

import Stack.IntStack;

import java.util.Scanner;

public class IntQueueTester {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IntQueue queue = new IntQueue(64);

        while (true) {
            System.out.println();
            System.out.printf("현재 데이터 개수: %d / %d\n", queue.size(), queue.getCapacity());
            System.out.print("(1) push (2) pop (3) peek (4) dump (0) exit: ");

            int menu = sc.nextInt();
            if (menu == 0) break;

            int temp;
            switch (menu) {
                case 1:
                    System.out.print("데이터: ");
                    temp = sc.nextInt();
                    try {
                        queue.enque(temp);
                    } catch (IntStack.OverflowIntStackException e) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;

                case 2:
                    try {
                        temp = queue.deque();
                        System.out.println("pop된 데이터는 " + temp + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 3:
                    try {
                        temp = queue.peek();
                        System.out.println("peek된 데이터는 " + temp + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 4:
                    queue.dump();
                    break;
            }
        }
    }
}
