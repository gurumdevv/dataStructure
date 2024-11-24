package Recursion;

import java.util.Scanner;

public class Hanoi {

    static void move(int no, int x, int y) {
        if (no > 1) move(no - 1, x, 6 - x - y); //x: 시작 기둥, y: 목표 기둥: 보조기둥: 6- x - y, n-1개 원판를 시작 -> 보조

        System.out.printf("원반[%d]을(를) %d번 기둥에서 %d번 기둥으로 옮김\n", no, x, y); //바닥 원판을 시작 -> 목표

        if (no > 1) move(no - 1, 6 - x - y, y); //x: 시작 기둥, y: 목표 기둥: 보조기둥: 6- x - y, n-1개 원판을 보조 -> 목표
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("하노이의 탑");
        System.out.print("원반의 개수: ");
        int n = sc.nextInt();

        move(n, 1, 3);
    }
}
