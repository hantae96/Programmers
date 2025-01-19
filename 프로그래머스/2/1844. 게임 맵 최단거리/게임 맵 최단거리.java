import java.util.LinkedList;

class Solution {

    static class Node {
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    static int[][] maps;
    static boolean[][] visited;

    public int solution(int[][] maps) {
        this.n = maps.length;      // 행의 개수
        this.m = maps[0].length;   // 열의 개수
        this.maps = maps;
        this.visited = new boolean[n][m]; // n x m 크기의 visited 배열 초기화

        return bfs();
    }

    static int bfs() {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1)); // 시작점 추가
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Node now = queue.remove();

            // 도착지점에 도달했는지 확인
            if (now.x == m - 1 && now.y == n - 1) {
                return now.count; // 최단 경로 반환
            }

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                // 유효한 위치인지 확인
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;

                // 방문하지 않았고, 이동 가능한 곳인지 확인
                if (maps[ny][nx] == 1 && !visited[ny][nx]) {
                    queue.add(new Node(nx, ny, now.count + 1)); // 새 노드 추가
                    visited[ny][nx] = true;                    // 방문 처리
                }
            }
        }

        return -1; // 도착할 수 없는 경우
    }
}