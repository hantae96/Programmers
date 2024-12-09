
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        array = new int[n+1];
        for(int i = 1; i<n+1;i++){
            array[i] = i;
        }

        int start = 0;
        int end = 0;
        int answer = 1; // n 자체를 직접 넣을 수 있음

        while(end != n){
            if(sum(start,end) > n){
               start++;
            } else if (sum(start,end) < n) {
                end++;
            }else{
                answer++;
                end++;
            }
        }

        System.out.println(answer);
    }

    public static int sum(int start, int end){
        int sum = 0;
        for(int i = start;i<=end;i++){
            sum += array[i];
        }
        return sum;
    }
}
