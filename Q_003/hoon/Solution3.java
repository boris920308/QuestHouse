import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 첫번째 줄
        String firstLine = br.readLine();
        int characterCount = Integer.parseInt(firstLine.split(" ")[0]);
        int levelCount = Integer.parseInt(firstLine.split(" ")[1]);
        ArrayList<Integer> levels = new ArrayList<>();

        for (int i = 0; i < characterCount; i++) {
            levels.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(levels);

        int min = levels.get(0);
        int max = levels.get(characterCount - 1) + levelCount;
        int result = min;

        while (min <= max) {
            int mid = (min + max) / 2;
            long totalPoints = 0;

            // 각 레벨을 mid로 만들기 위한 포인트 계산
            for (int i = 0; i < characterCount; i++) {
                if (levels.get(i) < mid) {
                    totalPoints += mid - levels.get(i);
                }
            }

            // 필요한 포인트가 주어진 포인트 이하인 경우
            if (totalPoints <= levelCount) {
                result = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        System.out.println(result);
    }
}
