import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n,m,answer;
    static int[][] map;
    static int[][] visited;

    static class Node{
        public int x;
        public int y;

        public int count;

        public Node(int x,int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new int[n][m];

        for(int i = 0;i<n;i++){
            String temp = br.readLine();
            for(int j = 0;j<m;j++){
                map[i][j] = temp.charAt(j) - '0';
            }
        }

        bfs(0,0);


    }

    public static void bfs(int x, int y){
        LinkedList<Node> queue = new LinkedList<>();
        visited[x][y] = 1;

        queue.add(new Node(x,y,1));

        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};

        while(!queue.isEmpty()){
            Node current = queue.pop();
            if(current.x == n-1 && current.y == m-1){
                System.out.println(current.count);
                break;
            }

            for(int i = 0;i<4;i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(0 > nx || nx > n-1 ||  0  > ny || ny > m-1){
                    continue;
                }

                if(visited[nx][ny] == 1 || map[nx][ny] == 0){
                    continue;
                }

                visited[nx][ny] = 1;
                queue.add(new Node(nx,ny,current.count + 1));
            }
        }
    }
}