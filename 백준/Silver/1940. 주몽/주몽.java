import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        int start = 0, end = n-1, answer = 0;

        while(start != end){
            int sum = array[start] + array[end];

            if(sum < m){
                start++;
            }else if(sum > m){
                end--;
            }else{
                // 일치할때
                answer++;
                start++;
            }
        }


        System.out.println(answer);
    }
}