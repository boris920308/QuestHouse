import java.util.Scanner;

/**
 * [BOJ] no.10869
 * https://www.acmicpc.net/problem/10869
 */

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input1 = sc.nextInt();
        int input2 = sc.nextInt();

        System.out.println(input1 + input2);
        System.out.println(input1 - input2);
        System.out.println(input1 * input2);
        System.out.println(input1 / input2);
        System.out.println(input1 % input2);

    }
}
