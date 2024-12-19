
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i<n;i++){
            String input = br.readLine();
            Stack<Character> stack = new Stack<>();

            for(int j =0;j<input.length();j++){
                char c = input.charAt(j);

                if(stack.isEmpty()){
                    stack.push(c);
                    continue;
                }

                if(stack.peek() == c){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }

        if(!stack.isEmpty()){
            continue;
        }
        answer++;
    }

    System.out.println(answer);

    }
}