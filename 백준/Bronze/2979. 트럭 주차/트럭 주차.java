import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int [] answer = new int [101];
        int[] price = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i = 0;i<3;i++){
            input = br.readLine();
            int [] time = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();

            for(int k = time[0];k<time[1];k++){
                answer[k] = ++answer[k];
            }
        }

        int result = 0;
        for(int i = 0;i<answer.length;i++){
            int count = answer[i];
            if(count == 1){
                result += count * price[0];
            } else if (count == 2) {
                result += count * price[1];
            } else if(count == 3){
                result += count * price[2];
            }
        }

        System.out.println(result);
    }
}