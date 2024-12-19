
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<input.length();i++){
            char c = input.charAt(i);
            if(c == '('){
                stack.push(i);
            }else if(c == ')'){
                if(stack.peek() + 1 == i){ // 괄호가 한칸차이가 나는 경우
                    stack.pop();
                    answer += stack.size();
                }else{
                    answer+=1;
                    stack.pop();
                }
            }
        }

        System.out.println(answer);



    }
}