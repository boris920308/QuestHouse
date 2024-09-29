import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * [BOJ] no.2805
 * https://www.acmicpc.net/problem/2805
 */

public class Solution1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫번째 줄
        String firstLine = br.readLine();
        int treeCount = Integer.parseInt(firstLine.split(" ")[0]);
        int needTreeLength = Integer.parseInt(firstLine.split(" ")[1]);
        ArrayList<Integer> trees = new ArrayList<>();
        String getTrees = br.readLine();
        for (int i = 0; i < treeCount; i++) {
            trees.add(Integer.parseInt(getTrees.split(" ")[i]));
        }

        Collections.sort(trees);

        int min = 0;
        int max = trees.get(treeCount - 1);
        int result = 0;
        System.out.println("max = " + max);

        while (min <= max) {
            int mid = (min + max) / 2;
            int totalLength = 0;

            // 중간값으로 나무를 자를 경우 얻을 수 있는 나무의 총 길이 계산
            for (int tree : trees) {
                if (tree > mid) {
                    totalLength += tree - mid;
                }
            }

            // 필요한 나무길이 이상일 경우 절단기 높이를 더 높게 설정한다.
            if (totalLength >= needTreeLength) {
                result = mid;
                min = mid + 1;
            } else {
                // 필요한 나무 길이 이하일경우 절단기 높이를 낮춘다
                max = mid - 1;
            }
        }

        System.out.println("result = " + result);

    }
}
