package Stack;

import java.util.Scanner;

public class IntStackTester {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IntStack stack = new IntStack(64);

        while (true) {
            System.out.println();
            System.out.printf("현재 데이터 개수: %d / %d\n", stack.size(), stack.getCapacity());
            System.out.print("(1) push (2) pop (3) peek (4) dump (0) exit: ");

            int menu = sc.nextInt();
            if (menu == 0) break;

            int temp;
            switch (menu) {
                case 1:
                    System.out.print("데이터: ");
                    temp = sc.nextInt();
                    try {
                        stack.push(temp);
                    } catch (IntStack.OverflowIntStackException e) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;

                case 2:
                    try {
                        temp = stack.pop();
                        System.out.println("pop된 데이터는 " + temp + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 3:
                    try {
                        temp = stack.peek();
                        System.out.println("peek된 데이터는 " + temp + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 4:
                    stack.dump();
                    break;
            }
        }
    }
}
