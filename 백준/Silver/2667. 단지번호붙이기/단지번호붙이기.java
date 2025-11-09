import com.sun.source.tree.BreakTree;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static int n;
    static int count;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = new int[]{-1,1,0,0};
    static int[] dy = new int[]{0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        visited = new boolean[n][n];
        map = new int[n][n];

        for(int i = 0;i<n;i++){
            String temp = br.readLine();
            for(int j = 0; j<n;j++){
                map[i][j] = temp.charAt(j) - '0';
            }
        }


        List<Integer> list = new ArrayList<>();

        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(!visited[i][j] && map[i][j] == 1){
//                    System.out.printf("탐색시작 %d %d\n",i,j);
                    count = 1;
                    visited[i][j] = true;
                    dfs(i,j);
                    list.add(count);
                }
            }
        }

        System.out.println(list.size());
        list.sort(null);
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    static void dfs(int x, int y){
        for(int i = 0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0 > nx || nx >= n || 0 > ny || ny >= n)
                continue;

            if(map[nx][ny] == 0)
                continue;

            if(visited[nx][ny])
                continue;

            visited[nx][ny] = true;
//            System.out.printf("%d %d\n",nx,ny);
            count++;
            dfs(nx,ny);
        }
    }

}
