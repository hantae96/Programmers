import java.util.*;
import java.io.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String args[]) throws FileNotFoundException {
        //Scanner sc = new Scanner(new File("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = sc.nextInt();

        System.out.println((char)(str.charAt(n-1)));
    }
}