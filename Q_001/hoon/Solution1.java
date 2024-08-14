import java.util.Scanner;

/**
 * [BOJ] no.2588
 * https://www.acmicpc.net/problem/2588
 */

public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 숫자 입력
        int input1 = sc.nextInt();
        int input2 = sc.nextInt();

        int units = input2 % 10; // 일의자리
        int tens = (input2 / 10) % 10; // 십의자리
        int hundreds = input2 / 100; // 백의자리

        System.out.println(input1 * units);
        System.out.println(input1 * tens);
        System.out.println(input1 * hundreds);

        System.out.println(input1 * input2);

    }
}
