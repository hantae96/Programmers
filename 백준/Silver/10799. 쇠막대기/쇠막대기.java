import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();
        
        int answer = 0;
        int end = 0;
        Stack<Character> stack = new Stack<>();

        int i = 0;
        while(i<input.length()){
            char c = input.charAt(i);

            if (c == '(' && input.charAt(i + 1) == ')') { // 레이저인 경우
                answer += stack.size();
                // System.out.println(stack.size());
                i += 2;
                continue;
            }
            
            if (c == '(') {
                stack.push('(');
                i++;
            }

            if (c == ')') {
                answer += 1; // 꼬다리
                stack.pop();
                i++;
            }


        }
        
        System.out.println(answer+end);

        
    }
}