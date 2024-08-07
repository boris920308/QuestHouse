package Q_001_hello.chung;
import java.util.Scanner;

// --- 백준 제출시
// public class Main
public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int user1 = scanner.nextInt(), user2 = scanner.nextInt();
        System.out.println(
                (user1 + user2) + "\n" +
                (user1 - user2) + "\n" +
                (user1 * user2) + "\n" +
                (user1 / user2) + "\n" +
                (user1 % user2)
        );
    }
}
