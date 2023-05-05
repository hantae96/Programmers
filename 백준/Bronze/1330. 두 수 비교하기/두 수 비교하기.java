import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int a = Integer.valueOf(input[0]);
        int b = Integer.valueOf(input[1]);

        if (a > b){
            System.out.println(">");
        }else if (a < b){
            System.out.println("<");
        }else{
            System.out.println("==");
        }

    }
}
