import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static HashMap<Integer, List<Integer>> map = new HashMap<>();
    static int n, m = 0;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        // Connected Component 구하는 문제
        // 그래프를 만들어서 하나씩 DFS로 탐색한다.
        // 방문 배열을 만들어서 체크

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];

        // 그래프 생성 (양방향 간선 추가)
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // u -> v 간선 추가
            List<Integer> valuesU = map.getOrDefault(u, new ArrayList<>());
            valuesU.add(v);
            map.put(u, valuesU);

            // v -> u 간선 추가 (양방향)
            List<Integer> valuesV = map.getOrDefault(v, new ArrayList<>());
            valuesV.add(u);
            map.put(v, valuesV);
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) { // 모든 노드 탐색
            if (!visited[i]) {
                answer++;
                dfs(i);
            }
        }

        System.out.println(answer);
    }

    static void dfs(int startNode) {
        visited[startNode] = true;
        List<Integer> values = map.getOrDefault(startNode, new ArrayList<>());
        for (int value : values) {
            if (!visited[value]) {
                dfs(value);
            }
        }
    }
}