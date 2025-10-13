import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int leftPtr = 0;
        int rightPtr = 1;
        int sum = rightPtr - leftPtr;
        int count = 0;
        while(leftPtr <= rightPtr){
            if(sum == n){
                rightPtr++;
                sum += rightPtr;
                count++;
            }
            else if(sum > n){
                sum -= leftPtr;
                leftPtr++;
            }
            else{
                rightPtr++;
                sum += rightPtr;
            }
        }

        System.out.println(count);

    }
}