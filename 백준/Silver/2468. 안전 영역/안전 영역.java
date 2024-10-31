import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max = 0; // 최대 높이 저장
    static int answer = 1; // 최소 안전영역 수를 1로 초기화

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        // 지도 정보 입력 및 최대 높이 구하기
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }

        // 각 높이에 대해 안전영역 수를 계산하여 answer 갱신
        for (int h = 1; h <= max; h++) {
            visited = new boolean[n][n];
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] > h && !visited[i][j]) {
                        count++; // 새로운 안전영역 발견 시 count 증가
                        dfs(i, j, h); // 연결된 모든 지역 방문
                    }
                }
            }
            answer = Math.max(answer, count); // answer를 최대 안전영역 수로 갱신
        }

        System.out.println(answer);
    }

    // DFS를 통해 연결된 모든 안전 영역 방문
    static void dfs(int x, int y, int h) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && map[nx][ny] > h) {
                dfs(nx, ny, h);
            }
        }
    }
}