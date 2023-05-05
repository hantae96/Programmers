import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws FileNotFoundException {
//        Scanner sc = new Scanner(new File("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int [] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();

        System.out.printf("%d %d",min,max);
    }
}