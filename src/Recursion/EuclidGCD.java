package Recursion;

import java.util.Scanner;

public class EuclidGCD {

    static int gcd(int x, int y) {
        System.out.println(x + "  "+ y);
        if (y == 0) return x;
        else return gcd(y, x % y);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("두 정수의 최대공약수 구하기");

        System.out.print("정수를 입력하세요: ");
        int x = sc.nextInt();
        System.out.print("정수를 입력하세요: ");
        int y = sc.nextInt();

        System.out.println("최대 공약수는 " + gcd(x, y) + "입니다.");
    }
}
