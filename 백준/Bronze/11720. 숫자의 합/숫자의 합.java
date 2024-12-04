
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String input = sc.nextLine();

        char[] arrays = input.toCharArray();

        int answer = 0;
        for(int i = 0;i<arrays.length;i++){
            answer += arrays[i] - '0';
        }

        System.out.println(answer);
    }
}