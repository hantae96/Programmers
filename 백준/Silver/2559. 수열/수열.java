
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int k = Integer.parseInt(temp[1]);

        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int max = -100000;
        for(int i = 0;i<numbers.length - k + 1;i++){
            int sum = sum(i,i+k,numbers);
            if(max < sum){
                max = sum;
            }
        }

        System.out.println(max);
    }

    public static int sum(int start, int n, int[] number){
        int answer = 0;
        for(int i = start;i<n;i++){
            answer += number[i];
        }
        return answer;
    }
}