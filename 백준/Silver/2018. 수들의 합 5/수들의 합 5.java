import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int lp = 0;
        int rp = 0;
        int sum = 0;
        int count = 1; 

        while (rp < n) {
            if (sum < n) {
                rp++;
                sum += rp;
            } else if (sum > n) {
                lp++;
                sum -= lp;
            } else {

                // System.out.printf("%d %d\n", lp, rp);
                rp++;
                sum += rp;
                count++;
            }
        }
        
        System.out.println(count);
    
        
    }
}