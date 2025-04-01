import java.util.*;

class Solution {
    public int solution(int[] orders) {
        int answer = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0;i<orders.length;i++){
            queue.offer(i+1);
        }
        
        for(int order : orders){
            if(!stack.isEmpty() && stack.peek() == order){
                answer++;
                stack.pop();
                continue;
            }
            
            while(!queue.isEmpty()  && queue.peek() < order){
                stack.push(queue.poll());
            }
            
            if(queue.peek() == order){
                answer++;
                queue.poll();
            }else{
                break;
            }
        }
        
        return answer;
    }
}