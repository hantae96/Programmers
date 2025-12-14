import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[] visited;
    static int n;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n];
        visited[0] = true;
        dfs(0, 0, 1, 0);

        System.out.println(answer);
    }

    static void dfs(int now, int start, int count, int cost) {
        if (count == n) {
            if (map[now][start] != 0) {
                answer = Math.min(answer, cost + map[now][start]);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] || map[now][i] == 0)
                continue;

            visited[i] = true;
            dfs(i, start, count + 1, cost + map[now][i]);
            visited[i] = false;
        }
    }
}