import java.util.*;
import java.io.*;


public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] input = br.readLine().split(" ");
            int a = Integer.valueOf(input[0]);
            int b = Integer.valueOf(input[1]);
            
            System.out.println(a*b);
            
    }
}
