import java.util.Arrays;

class Solution {
    public int solution(int n, int m, int[] section) {

        int answer = 0;
        // 현재 덮을 수 있는 최대 범위
        int coverage = 0;

        for (int s : section) {
            // 만약 현재 구역 s가 coverage 범위 안에 있으면 이미 칠해진 상태
            if (s <= coverage) {
                continue;
            }
            // coverage 범위 밖인 s를 만나면, 새로운 롤러 칠을 시작
            answer++;
            // 새로 칠할 때, [s ~ s + m - 1] 구간 커버
            coverage = s + m - 1;
        }

        return answer;
    }
}