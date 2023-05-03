import java.util.*;
import java.io.*;


public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        int A = Integer.valueOf(input[0]);
        int B = Integer.valueOf(input[1]);
        int C = Integer.valueOf(input[2]);
        
        System.out.println((A+B)%C);
        System.out.println(((A%C) + (B%C))%C);
        System.out.println((A*B)%C);
        System.out.println(((A%C) * (B%C))%C);
    }
}
