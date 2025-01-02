
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static public int[][] map = new int[1001][1001];
    static public boolean[] visited = new boolean[1001];

    static int n;
    static int m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            map[u][v] = 1;
            map[v][u] = 1;
        }

        int result = 0;
        for(int i = 1; i<n+1;i++){
            if(visited[i] == false){
                dfs(i);
                result++;
            }
        }

        System.out.println(result);
    }

    public static void dfs(int index){
        if(visited[index] == true){
            return;
        }
        visited[index] = true;
        for(int i = 1;i<n+1;i++){
            if(map[index][i] == 1){
                dfs(i);
            }
        }
    }
}