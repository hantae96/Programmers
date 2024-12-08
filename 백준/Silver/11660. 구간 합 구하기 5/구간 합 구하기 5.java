import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] origin = new int[n+1][n+1]; // 구간합을 구할때 앞에 0이 있어야 첫번째 구간합도 구할 수 있다.
        int[][] sum = new int[n+1][n+1];

        for(int i = 1;i<n+1;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1;j<n+1;j++){
                int value = Integer.parseInt(st.nextToken());
                origin[i][j] = value;
            }
        }

        for(int i = 1;i<n+1;i++){
            for(int j = 1;j<n+1;j++){
                sum[i][j] = sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1] + origin[i][j];
            }
        }

        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            System.out.println(sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1-1][y1-1]);
        }
    }
}
