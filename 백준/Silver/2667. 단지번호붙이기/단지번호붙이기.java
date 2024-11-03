
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int[][] graph;
    static boolean[][] visited;

    // 이동 방향 (상하좌우)
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        graph = new int[n][n];
        visited = new boolean[n][n];

        // 입력 받아서 그래프 구성
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = temp.charAt(j) - '0'; // 문자열에서 숫자 변환
            }
        }

        List<Integer> list = new ArrayList<>(); // 각 단지의 크기를 저장할 리스트

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) { // 방문하지 않은 1인 경우 새로운 단지 시작
                    int count = dfs(i, j); // 해당 단지 크기 계산
                    list.add(count); // 리스트에 추가
                }
            }
        }

        Collections.sort(list); // 오름차순 정렬
        System.out.println(list.size()); // 단지 수 출력
        list.forEach(System.out::println); // 각 단지의 크기 출력
    }

    // DFS 탐색
    static int dfs(int x, int y) {
        visited[x][y] = true; // 현재 위치 방문 처리
        int count = 1; // 시작 위치도 포함하므로 1로 시작

        // 상하좌우로 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 그래프 범위 내에 있고 방문하지 않은 1인 경우
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (!visited[nx][ny] && graph[nx][ny] == 1) {
                    count += dfs(nx, ny); // 재귀적으로 연결된 부분 모두 탐색
                }
            }
        }
        return count; // 단지 크기 반환
    }
}