import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array); // nlogn

        int answer = 0;

        for(int i = 0;i<n;i++){
            int start = 0;
            int end = n - 1;

            while(start < end && start >= 0 && end < n){
                int sum = array[start] + array[end];
                if(sum < array[i]){
                    start++;
                }else if(sum > array[i]){
                    end--;
                }else{
                    if(start == i){
                        start++;
                        continue;
                    }

                    if(end == i){
                        end--;
                        continue;
                    }
                    // 10이 없음
                    answer+=1;
                    break;
                }
            }


        }

        System.out.println(answer);
    }
}