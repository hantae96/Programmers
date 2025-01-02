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

        // DFS 탐색
        for (int i = 0; i < n; i++) {
            if (dfs(i) >= 5) { // 깊이가 5 이상이면 조건 만족
                arrive = true;
                break;
            }
        }

        // 결과 출력
        if (arrive) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }

    // DFS: 깊이를 반환
    static int dfs(int number) {
        visited[number] = true; // 방문 처리

        int maxDepth = 1; // 현재 노드 깊이

        for (Integer friend : graph[number]) {
            if (!visited[friend]) { // 방문하지 않은 노드만 탐색
                int depth = dfs(friend) + 1; // 깊이를 계산하면서 재귀 호출
                if (depth >= 5) { // 깊이가 5 이상이면 조기 종료
                    return depth;
                }
                maxDepth = Math.max(maxDepth, depth); // 최대 깊이 갱신
            }
        }

        visited[number] = false; // 백트래킹
        return maxDepth; // 최대 깊이를 반환
    }
}