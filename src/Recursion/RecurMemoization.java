package Recursion;

import java.util.Scanner;

public class RecurMemoization {

    static String[] memo;

    static void recur(int n) {
        if (memo[n + 1] != null) {
            System.out.print(memo[n + 1]);
        } else {
            if (n > 0) {
                recur(n - 1);
                System.out.println(n);
                recur(n - 2);
                memo[n + 1] = memo[n] + n + "\n" + memo[n - 1];
            } else {
                memo[n + 1] = ""; //recur(0)와 recur(-1)을 빈 문자열로 메모화, n+1에 저장하는 이유도 0과 -1의 케이스를 저장하기 위함
            }
        }
    }
    /*
    memo[1] = ""
    memo[0] = ""
    memo[2] = "" + 1  + "\n" + ""
    memo[3] = "1\n" + 2 + "\n" +  ""
    memo[4] = "1\n 2\n" + 3 + "1\n"
    ...
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수를 입력하세요: ");
        int x = sc.nextInt();

        memo = new String[x + 2];
        recur(x);
    }
}
