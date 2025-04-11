import java.util.*;


class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        
        Queue<Integer> queue = new LinkedList<>();
        int n = speeds.length;
        
        for(int i = 0;i<n;i++){
            int day = (100 - progresses[i]) / speeds[i];
            day += (100 - progresses[i]) % speeds[i] > 0 ? 1 : 0;
            queue.add(day);
        }
        
        while(!queue.isEmpty()){
            int top = queue.poll();
            int count = 1;

            while(!queue.isEmpty()){
                if(top >= queue.peek()){
                    queue.poll();
                    count++;
                }else{
                    break;
                }
            }
            
            answer.add(count);
        }
        
        
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}