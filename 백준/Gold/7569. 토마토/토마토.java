import java.io.*;
import java.util.*;

public class Main {
    static LinkedList<Node> queue = new LinkedList<>();
    static int[][][] array;
    static boolean[][][] visited;
    static int[][] move = new int[][]{{1,0,0},{-1,0,0},{0,1,0},{0,-1,0},{0,0,1},{0,0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken()); // x
        int n = Integer.parseInt(st.nextToken()); // y
        int h = Integer.parseInt(st.nextToken()); // z

        array = new int[h][n][m];
        visited = new boolean[h][n][m];

        boolean isAlreayAll = true;

        int remainTomatoCount = 0;
        for(int z = 0; z<h;z++){
            for(int y = 0;y<n;y++){
                st = new StringTokenizer(br.readLine());
                for(int x = 0;x<m;x++){
                    int tomato = Integer.parseInt(st.nextToken());
                    array[z][y][x]= tomato;

                    if(array[z][y][x] == 1)
                    {
                        queue.add(new Node(x,y,z,1));
                    }

                    if(array[z][y][x] == 0)
                    {
                        remainTomatoCount++;
                        isAlreayAll = false;
                    }
                }
            }
        }


        if(isAlreayAll){
            System.out.println(0);
            return;
        }

        int days = bfs(m,n,h,remainTomatoCount);
        System.out.println(days);

    }

    static class Node{
        int x;
        int y;
        int z;
        int day;
        public Node(int x, int y, int z,int day){
            this.x = x;
            this.y = y;
            this.z = z;
            this.day = day;
        }
    }

    static int bfs(int m, int n, int h, int remainTomatoCount){
        int targetTomatoCount = 0;
        while(!queue.isEmpty()){
            Node now = queue.pop();
            visited[now.z][now.y][now.x] = true;

            for(int i = 0;i<move.length;i++){
                int[] command = move[i];

                int dx = now.x + command[0];
                int dy = now.y + command[1];
                int dz = now.z + command[2];

                if(0 > dx || dx >= m || 0 > dy || dy >= n || 0 > dz || dz >= h) continue;
                if(array[dz][dy][dx] == -1) continue;
                if(visited[dz][dy][dx]) continue;

                if(array[dz][dy][dx] == 0){
                    array[dz][dy][dx] = 1;
                    visited[dz][dy][dx] = true;
                    targetTomatoCount++;
                }

                if(remainTomatoCount == targetTomatoCount)
                    return now.day;

                queue.add(new Node(dx,dy,dz,now.day+1));
            }
        }

        return -1;
    }
}