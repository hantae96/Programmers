import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();

        Stack<Integer> stack = new Stack<>();
        int add = 0;
        for(int i = 0; i<n;i++){
            int temp = Integer.parseInt(br.readLine());

            while(temp > add){
                stack.push(++add);
                sb.append("+\n");
            }

            boolean isPop = false;
            while(!stack.isEmpty() && temp <= stack.peek()){
                isPop = true;
                stack.pop();
                sb.append("-\n");
            }

            if(!isPop){
                System.out.println("NO");
                return;
            }
        }

        System.out.println(sb);

    }
}