import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int m = sc.nextInt();
        sc.nextLine();

        int [] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int answer = 0;
        for(int i = 0;i<arr.length -1;i++){
            for(int j = i+1;j<arr.length;j++){
                if(arr[i] + arr[j] == m) answer++;
            }
        }

        System.out.println(answer);


    }
}