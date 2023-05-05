import java.util.*;
import java.io.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String args[]) throws FileNotFoundException {
    //    Scanner sc = new Scanner(new File("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = IntStream.range(1,n+1).toArray();
        for(int i = 0;i<m;i++){
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            int tmp =  arr[a];
            arr[a] = arr[b];
            arr[b] = tmp;
        }

        for(int s : arr){
            System.out.print(s+" ");
        }

    }
}