
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    static int m,n,k,sum;
    static int[][] map;
    static int[][] visited;

    static int[] dx = new int[]{-1,1,0,0};
    static int[] dy = new int[]{0,0,-1,1};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        k = sc.nextInt();
        sc.nextLine();

        map = new int[m][n];
        visited = new int[m][n];

        for(int i = 0;i<k;i++){
            int [] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] startPos = new int[]{input[0],input[1]};
            int[] endPos = new int[]{input[2],input[3]};
            fill(startPos,endPos);
        }

        int count = 0;
        List<Integer> areaList = new ArrayList<>();

        for(int y = 0;y<m;y++){
            for(int x = 0; x<n;x++){
                if(map[y][x] > 0) continue;
                if(visited[y][x] == 1) continue;
                count++;
//                dfs(y,x);
                areaList.add(dfs(y,x));
            }
        }

        System.out.println(count);

        Collections.sort(areaList);
        for(int elem : (areaList)){
            System.out.printf("%d ",elem);
        }
    }

    public static int dfs(int y,int x){
        if(visited[y][x] == 1){
            return 0;
        }

        visited[y][x] = 1;
        int sum = 1;

        for(int i = 0;i<4;i++){
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(0>ny || ny >= m || 0> nx || nx >= n) continue;
            if(map[ny][nx] > 0) continue;

            sum += dfs(ny,nx);
        }

        return sum;
    }


    public static void fill(int[] startPos, int[] endPos){
        for(int y = startPos[1];y<endPos[1];y++){
            for(int x = startPos[0];x<endPos[0];x++){
                map[y][x] = ++map[y][x];
            }
        }
    }

}

