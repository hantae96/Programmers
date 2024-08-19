import java.util.*;


class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<Character>();
        for(Character c : s.toCharArray()){
            if(stack.isEmpty()){
                stack.push(c);
            }else{
                Character top = stack.peek();
                if(top == c){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }
        }
        
        if(stack.isEmpty()){
            return 1;
        }else{
            return 0;
        }
    }
}