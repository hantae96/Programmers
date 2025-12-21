import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        int count = 0;
        for (int i = 1; i <= Integer.MAX_VALUE; i++) {
            String temp = i + "";
            if (temp.contains("666")) {
                count++;
            }

            if (count == n) {
                System.out.println(temp);
                return;
            }
        }
    }
}