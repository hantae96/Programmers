import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    static int [] dx = new int[]{-1,1,0,0};
    static int [] dy = new int[]{0,0,-1,1};
    static int [][] visited;
    static int [][] map;
    static int n,m;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for(int z = 0;z<t;z++){
            m = sc.nextInt(); // 가로길이
            n = sc.nextInt(); // 세로길이
            int k = sc.nextInt(); // 배추가 심어져 있는 위치의 갯수
            sc.nextLine();

            map = new int[n][m];
            visited = new int[n][m];

            // 흰지렁이 표시
            for(int i =0;i<k;i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                map[y][x] = 1;
            }


            int answer = 0;
            for(int y = 0;y<n;y++){
                for(int x = 0;x<m;x++){
                    if(visited[y][x] == 0 && map[y][x] == 1){
                        answer +=1;
                        dfs(y,x);
                    }
                }
            }
            System.out.println(answer);
        }
    }

    static void dfs(int y,int x){
        if(map[y][x] == 0 || visited[y][x] == 1){
            return;
        }

        visited[y][x] = 1;

        for(int d = 0;d<4;d++){
            int nextY = y+dy[d];
            int nextX = x+dx[d];

            if(0 > nextY || nextY >= n || 0 > nextX || nextX >= m) continue; // 범위
            if(map[nextY][nextX] == 0) continue;
            dfs(nextY,nextX);
        }
    }
}

