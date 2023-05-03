import java.util.*;
import java.io.*;


public class Main{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String [] arr = br.readLine().split(" ");
        
        double a = Integer.valueOf(arr[0]);
        double b = Integer.valueOf(arr[1]);
        
        System.out.println(a/b);
    }
}
