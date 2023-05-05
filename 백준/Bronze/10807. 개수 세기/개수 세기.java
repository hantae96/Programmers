import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws FileNotFoundException {
        //Scanner sc = new Scanner(new File("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] input = new int[n];

        for (int i =0;i<n;i++){
            input[i] = sc.nextInt();
        }
        int v = sc.nextInt();
        int count = (int) Arrays.stream(input).filter(num -> num == v).count();
        System.out.println(count);
    }
}