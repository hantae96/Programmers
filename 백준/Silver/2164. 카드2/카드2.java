
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Queue<Integer> que = new LinkedList<>();
        for(int i = 1;i<n+1;i++){
            que.add(i);
        }

        while(que.size() > 1){
            que.remove();
            que.add(que.remove());
        }

        System.out.println(que.peek());
    }
}