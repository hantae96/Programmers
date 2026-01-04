import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int elem : scoville){
            minHeap.offer(elem);
        }
        
        
        while(minHeap.size() > 1 && minHeap.peek() < K){
            int value = minHeap.poll() + (minHeap.poll() * 2);
            minHeap.offer(value);
            answer+=1;
        }
        
        if(minHeap.peek() < K){
            return -1;
        }
        
        
        
        return answer;
    }
}