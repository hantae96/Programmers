import java.util.*;


class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)right-(int)left+1]; 
        
        int idx = 0;
        for(long i = left; i<=right;i++){
            long x = i/n;
            long y =i%n;
            
            int value = (int)Math.max(x,y)+1;
            answer[idx] = value;
            idx++;
        }
        
        
        
        return answer;
    }
}