import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");

        int N = Integer.parseInt(input1[0]);    // 캐릭터의 개수
        int K = Integer.parseInt(input1[1]);    // 레벨 총 합
        long[] levels = new long[N];            // 캐릭터 레벨

        for (int i = 0; i < N; i++) {
            levels[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(levels);

        long min = levels[0];
        long max = levels[N - 1] + K;
        long answer = 0;

        while (min <= max) {
            long mid = (min + max) / 2;

            // 레벨 업
            long totalLevel = 0;
            for (int i = 0; i < N; i++) {
                if (levels[i] < mid) {
                    totalLevel += mid - levels[i];
                }
            }

            if (totalLevel <= K) {
                answer = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }

        }
        System.out.println(answer);
    }
}
