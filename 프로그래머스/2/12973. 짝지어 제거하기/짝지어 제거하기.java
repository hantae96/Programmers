import java.util.*;

class Solution
{
    public int solution(String s)
    {

        Stack<Character> stack = new Stack<>();
        
        int idx = 0;
        while(idx < s.length()){
            Character c = s.charAt(idx);
            if(stack.isEmpty()){
                stack.push(c);
            }else{
                if(stack.peek() == c){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }
            idx++;
        }

        if(stack.isEmpty()){
            return 1;
        }else{
            return 0;
        }
    }
}