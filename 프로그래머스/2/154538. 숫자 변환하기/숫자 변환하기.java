import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        if (x == y) return 0;

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(x);
        visited.add(x);

        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size(); // 현재 레벨 노드 수

            for (int i = 0; i < size; i++) {
                int now = queue.poll();

                if (now == y) {
                    return level;
                }

                // 다음 숫자 계산
                int[] nexts = {now + n, now * 2, now * 3};

                for (int next : nexts) {
                    if (next <= y && !visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }

            level++; // 현재 레벨의 모든 노드 처리 후 증가
        }

        return -1; // y에 도달할 수 없음
    }
}