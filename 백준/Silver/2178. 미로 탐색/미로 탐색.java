import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int[][] visited;
    static int[][] map;
    static int[] dx = new int[]{-1,1,0,0};
    static int[] dy = new int[]{0,0,-1,1};
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new int[n][m];
        map = new int[n][m];

        for(int i = 0;i<n;i++){
            String input = br.readLine();
            for(int j = 0;j<m;j++){
                map[i][j] = input.charAt(j) - '0';
            }
        }

        System.out.println(bfs(new Node(0,0))+1);

//        for(int i = 0;i<n;i++){
//            for(int j = 0;j<m;j++){
//                System.out.printf("%d",visited[i][j]);
//            }
//            System.out.println();
//        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    static int bfs(Node node){
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);


        while (!queue.isEmpty()){
            Node pop = queue.pop();

            for(int i = 0;i<4;i++){
                int nx = dx[i] + pop.x;
                int ny = dy[i] + pop.y;

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(map[nx][ny] == 0)  continue;
                if(visited[nx][ny] != 0) continue;

                visited[nx][ny] = visited[pop.x][pop.y] + 1;
                queue.add(new Node(nx,ny));
            }
        }

        return visited[n-1][m-1];
    }
}
