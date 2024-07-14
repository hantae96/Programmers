import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static int [] index;
    public static int [] output;
    public static int N,R;


    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        int answer = 0;
        for(int i = 0;i<n;i++){
            String input = sc.nextLine();
            Stack<String> stack = new Stack<>();
            for(int j =0;j<input.length();j++){
                String temp = String.valueOf(input.charAt(j));
                if(stack.isEmpty()){
                    stack.push(temp);
                }else{
                    String top = stack.peek();
                    if(top.equals(temp)){
                        stack.pop();
                    }else{
                        stack.push(temp);
                    }
                }
            }

            if(stack.isEmpty()){
                answer++;
            }
        }

        System.out.println(answer
        );
    }

}