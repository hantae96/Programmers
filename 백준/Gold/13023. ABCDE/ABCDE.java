import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static boolean arrive;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n];
        visited = new boolean[n];

        // 그래프 초기화
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        // DFS 탐색 시작
        for (int i = 0; i < n; i++) {
            dfs(i, 1); // 깊이 1부터 시작
            if (arrive) {
                break; // 도달 시 종료
            }
        }

        // 결과 출력
        if (arrive) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }

    static void dfs(int number, int depth) {
        if (depth == 5) { // 깊이가 5일 경우 도달 성공
            arrive = true;
            return;
        }

        visited[number] = true; // 방문 처리

        // 현재 노드의 인접 노드 탐색
        for (Integer friend : graph[number]) {
            if (!visited[friend]) { // 방문하지 않은 경우만 탐색
                dfs(friend, depth + 1);
                if (arrive) return; // 도달하면 조기 종료
            }
        }

        visited[number] = false; // 백트래킹 - 방문 상태 복구
    }
}