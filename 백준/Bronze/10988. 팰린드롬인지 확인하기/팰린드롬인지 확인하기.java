
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        String reverese = new StringBuilder(input).reverse().toString();

        if(input.equals(reverese)){
            System.out.println("1");
        }else{
            System.out.println("0");
        }
    }
}