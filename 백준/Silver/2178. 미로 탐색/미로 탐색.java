import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static int[][] visited = new int[100][100];
    public static int[][] map;
    public static int n,m;
    public static int [] dx = new int[]{-1,1,0,0};
    public static int [] dy = new int[]{0,0,-1,1};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        map = new int[n][m];

        for(int i = 0;i<n;i++){
            String input = sc.nextLine();
            for(int j = 0;j<m;j++){
                map[i][j] = input.charAt(j) - '0';
            }
        }


        bfs(0,0);
//
//        for(int i = 0;i<n;i++){
//            for(int j = 0;j<m;j++){
//                System.out.print(visited[i][j]);
//            }
//            System.out.println();
//        }

        System.out.println(visited[n-1][m-1]);
    }

    public static void bfs(int x,int y){
        // bfs를 위해 queue를 생성하고, 시작 노드를 넣는다.
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = 1;

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int weight = visited[curr[0]][curr[1]];
            // 상하좌우 이동할 좌표
            for(int i = 0;i<4;i++){
                int[] next = new int[]{curr[0] + dx[i],curr[1] + dy[i]};
                if(0>next[0] || next[0] >= n || 0>next[1] || next[1] >= m) continue; // 범위
                if(map[next[0]][next[1]] == 0) continue;
                if(visited[next[0]][next[1]] != 0) continue;; // 이미 방문한 곳
                queue.add(new int[]{next[0],next[1]});
                visited[next[0]][next[1]] = weight+1;
            }
        }
    }

}

