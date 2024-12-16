
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for(int i = 0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            if(command.equals("push")){
                stack.push(Integer.parseInt(st.nextToken()));
            }else if(command.equals("top")){
                if(stack.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(stack.peek());
                }
            }else if(command.equals("size")){
                System.out.println(stack.size());
            }else if(command.equals("pop")){
                if(stack.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(stack.pop());
                }
            }else if(command.equals("empty")){
                if(stack.isEmpty()){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }
        }
    }
}