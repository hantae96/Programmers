
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int answer = 0;

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m]; // 방문 여부 체크용 배열

        for (int i = 0; i < n; i++) {
            String temp = sc.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = temp.charAt(j) - '0';
            }
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1)); // 초기 위치와 이동 단계

        while (!queue.isEmpty()) {
            Node now = queue.remove();

            // 도착 지점에 도달한 경우
            if (now.x == n - 1 && now.y == m - 1) {
                answer = now.move;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true; // 방문 처리
                    queue.add(new Node(nx, ny, now.move + 1)); // 현재 이동 단계 +1
                }
            }
        }

        System.out.println(answer);
    }

    static class Node {
        int x;
        int y;
        int move;

        public Node(int x, int y, int move) {
            this.x = x;
            this.y = y;
            this.move = move;
        }
    }
}