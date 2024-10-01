import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * [BOJ] no.2805
 * https://www.acmicpc.net/problem/2805
 */

public class Solution1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");
        String[] input2 = br.readLine().split(" ");

        /*
         * 입력
         * */
        int N = Integer.parseInt(input1[0]);        // 나무 개수
        int M = Integer.parseInt(input1[1]);        // 상근이가 집으로 가져가려고 하는 나무의 길이
        int[] trees = Arrays.stream(input2)
                            .mapToInt(Integer::parseInt)
                            .toArray();

        /*
         * 변수
         * */
        int height = 0;                     // 절단기 높이
        int min = 0;                        // 최솟값
        int max = Arrays.stream(trees)      // 최댓값
                        .max()
                        .orElse(0);

        /*
         * 이진 탐색
         * */
        while(min <= max) {
            int mid = (min + max) / 2;      // 중간 값

            // 나무 절단
            long totalWood = 0;
            for (int tree : trees) {
                if (tree > mid) totalWood += (tree - mid);
            }

            // 탐색
            if (totalWood >= M) {
                min = mid + 1;
                height = mid;
            } else {
                max = mid - 1;
            }
        }
        System.out.println(height);
    }
}
