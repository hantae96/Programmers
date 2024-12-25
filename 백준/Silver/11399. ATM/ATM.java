
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] input = new int[n];
        for(int i = 0;i<n;i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);

        int [] sum = new int[n];
        sum[0] = input[0];

        for(int i = 1;i<n;i++){
            sum[i] = sum[i-1] + input[i];
        }

        int answer = 0;
        for(int i = 0;i<sum.length;i++){
            answer += sum[i];
        }

        System.out.println(answer);

    }
}