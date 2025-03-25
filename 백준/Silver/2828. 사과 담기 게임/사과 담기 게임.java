
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt((br.readLine()));

        int answer = 0;
        int left = 1;
        for(int i = 0;i<j;i++){
            int apple = Integer.parseInt(br.readLine());
            int right = left + m -1;
            // 바구니 안에 들어왔을때
            if(left <= apple && apple <= right){
                continue;
            }

            if(apple < left){
                answer += left - apple;
                left = apple;
            }

            if(right < apple){
                answer += apple - right;
                left = apple - m + 1;
            }
        }

        System.out.println(answer);
    }




}