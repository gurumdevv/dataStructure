package Recursion;

import Stack.IntStack;

import java.util.Scanner;

public class AlternativeRecur {

    static void recur(int n) {
        IntStack stack = new IntStack(n);

        while (true) {
            if (n > 0) {
                stack.push(n);
                n = n - 1;
                continue;
            }

            if (!stack.isEmpty()) {
                n = stack.pop();
                System.out.println(n);
                n = n - 2;
                continue;
            }
            break;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수를 입력하세요: ");
        int x = sc.nextInt();

        recur(x);
    }
}
