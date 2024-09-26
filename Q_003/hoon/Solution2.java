import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * [BOJ] no.2110
 * https://www.acmicpc.net/problem/2110
 */

public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫번째 줄
        String firstLine = br.readLine();
        int houseCount = Integer.parseInt(firstLine.split(" ")[0]);
        int routerCount = Integer.parseInt(firstLine.split(" ")[1]);
        ArrayList<Integer> houses = new ArrayList<>();

        for (int i = 0; i < houseCount; i++) {
            houses.add(Integer.parseInt(br.readLine()));
        }

        // 집 위치 정렬
        Collections.sort(houses);

        int min = 1; // 최소거리
        int max = houses.get(houseCount - 1) - houses.get(0); // 최대거리
        int result = 0;

        while (min <= max) {
            int mid = (min + max) / 2; // 중간값

            // 중간값을 간격으로 공유기 설치가 가능한지 확인
            if (canInstall(houses, routerCount, mid)) {
                // mid 값이 설치가 가능한경우 저장 후 더 큰 간격을 탐색
                result = mid;
                min = mid + 1;
            } else {
                // 설치가 불가능한경우 더 작은 간격을 탐색
                max = mid - 1;
            }
        }

        System.out.println(result);
    }

    private static boolean canInstall(ArrayList<Integer> houses, int routerCount, int gap) {
        // 첫 번째 집에 공유기 설치
        int count = 1; // 설치한 공유기 갯수
        int lastInstalled = houses.get(0); // 마지막으로 공유기 설치한 집

        for (int i = 1; i < houses.size(); i++) {
            // 현재 집과 마지막으로 설치한 집 사이의 거리가 gap 이상이면 공유기 설치
            if (houses.get(i) - lastInstalled >= gap) {
                count++;
                lastInstalled = houses.get(i);
            }
        }

        return count >= routerCount;
    }
}
