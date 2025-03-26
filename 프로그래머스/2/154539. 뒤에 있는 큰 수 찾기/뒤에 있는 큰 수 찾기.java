import java.util.*;


class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
            
        int endIdx = answer.length -1;
        answer[endIdx] = -1;
        stack.push(numbers[endIdx]);
        
        for(int i = endIdx-1;i>=0;i--){
            
            int top = stack.peek();
            int now = numbers[i];
            if(top > now){
                answer[i] = top;
            }else{
                while(!stack.isEmpty() && stack.peek() <= now){
                    stack.pop();
                }
                
                if(stack.isEmpty()){
                    answer[i] = -1;
                }else{
                    answer[i] = stack.peek();
                }
            }
            
            stack.push(now);
        }
       
        
        return answer;
    }
}