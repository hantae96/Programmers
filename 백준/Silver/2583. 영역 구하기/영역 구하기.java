import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static int[][] map;

    static int m,n;
    static int[] dx = new int[]{-1,1,0,0};
    static int[] dy = new int[]{0,0,-1,1};

    public static void main(String[] args) throws Exception {

        int answer=  0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        visited = new boolean[m][n];
        map = new int[m][n];

        for(int i = 0; i<k;i++){
            st = new StringTokenizer(br.readLine());
            int downX = Integer.parseInt(st.nextToken());
            int downy = Integer.parseInt(st.nextToken());

            int upX = Integer.parseInt(st.nextToken());
            int upY = Integer.parseInt(st.nextToken());

            for(int x = downX;x<upX;x++){
                for(int y = downy;y<upY;y++){
                    map[y][x] = 1;
                }
            }
        }



        int split = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(visited[i][j] || map[i][j] == 1){
                    continue;
                }

                visited[i][j] = true;
                split++;
                list.add(dfs(i,j));
                }
            }

        System.out.println(split);
        Collections.sort(list);
        for(int i : list){
            System.out.printf("%d ", i);
        }
    }

    static int dfs(int x, int y){
        int count = 1;
        for(int i = 0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0 > nx || nx >= m || 0 > ny || ny >= n) continue;
            if(visited[nx][ny]) continue;
            if(map[nx][ny] == 1) continue;

            visited[nx][ny] = true;
            count += dfs(nx,ny);
        }

        return count;
    }



}