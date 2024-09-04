import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
    
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0;i<progresses.length;i++){
            int workTime = (int)Math.ceil((100.0 - progresses[i])/speeds[i]);
            queue.add(workTime);
        }
        
        int first = queue.remove();
        int count = 1;
        
         while(true){
             
            if(queue.size() == 0){
                answer.add(count);
                break;
            }
             
             int elem = queue.peek();
             if(first >= elem){
                 count++;
                 queue.remove();
             }else{
                 answer.add(count);
                 count = 1;
                 first = queue.remove();
             }
        }
        
            System.out.println(answer);
        
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}