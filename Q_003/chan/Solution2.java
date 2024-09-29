import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");

        int N = Integer.parseInt(input1[0]);    // 집 개수
        int C = Integer.parseInt(input1[1]);    // 공유기 개수
        int[] house = new int[N];               // 집 위치

        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house);

        int min = 1;                           // 공유기 최소 간격
        int max = house[N - 1] - house[0];     // 공유기 최대 간격
        int answer = 0;                        // 정답

        while (min <= max) {
            int mid = (min + max) / 2;

            // 공유기 설치
            int routerCnt = 1;                 // 설치한 공유기 개수
            int routerHouse = house[0];        // 설치한 공유기 위치
            for (int i = 1; i < N; i++) {
                if (house[i] - routerHouse >= mid) {
                    routerCnt++;
                    routerHouse = house[i];
                }
            }

            // 탐색
            if (routerCnt >= C) {
                min = mid + 1;
                answer = mid;
            } else {
                max = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
