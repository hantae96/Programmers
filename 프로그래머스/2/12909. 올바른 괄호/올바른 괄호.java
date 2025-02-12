import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(stack.isEmpty()){
                stack.push(c);
            }else{
                if(c == '('){
                    stack.push(c);
                }
                
                char top = stack.peek();
                if(c == ')' && top == '('){
                    stack.pop();
                }
                
                if(c == ')' && top == ')'){
                    stack.push(c);
                }
                
            }
            
            
            
        }

        return stack.size() == 0;
    }
}