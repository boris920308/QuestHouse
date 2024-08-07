package Q_001_hello.chung;
import java.util.Scanner;

// --- 백준 제출시
// public class Main
public class Solution1 {
    public static int submit(int a, int b){
        System.out.println(a*b);
        return a * b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int user1 = scanner.nextInt();
        int user2 = scanner.nextInt();

        int item1 = user2 % 10;
        int item2 = (user2 / 10) % 10;
        int item3 = (user2 / 100) % 10;

        int step1 = submit(user1, item1);
        int step2 = submit(user1, item2);
        int step3 = submit(user1, item3);

        int total = step1 + (step2 * 10) + (step3 * 100);
        System.out.println(total);
    }
}