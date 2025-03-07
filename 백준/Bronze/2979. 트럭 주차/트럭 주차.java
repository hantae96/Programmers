
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] price = new int[3];
        for(int i = 0;i<3;i++){
            price[i] = Integer.parseInt(st.nextToken());
        }

        int[] countArr = new int[101];
        int answer = 0;
        for(int i = 0;i<3;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            for(int j = start;j<end;j++){
                countArr[j] += 1;
            }
        }

        for(int i = 1;i<countArr.length;i++){
                int count = countArr[i];
                if(count != 0){
                    answer += price[countArr[i]-1] * countArr[i];
                }
        }

        System.out.println(answer);
    }
}