class Solution {

    static int count = 0;
    static int target;

    public int solution(int[] numbers, int target) {
        this.target = target;
        count = 0; // 초기화

        // DFS 시작
        dfs(numbers, 0, 0);

        return count;
    }

    // DFS 메서드
    static void dfs(int[] numbers, int idx, int sum) {
        // 종료 조건: 모든 숫자를 사용했을 때
        if (idx == numbers.length) {
            if (sum == target) {
                count++; // 목표값에 도달하면 count 증가
            }
            return;
        }

        // 현재 숫자를 더하거나 빼는 두 가지 경우로 탐색
        dfs(numbers, idx + 1, sum + numbers[idx]); // 더하기
        dfs(numbers, idx + 1, sum - numbers[idx]); // 빼기
    }
}