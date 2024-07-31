import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        
        Arrays.sort(d);
        
        int idx = 0;
        int sum = 0;
        int count = 0;
         while(idx < d.length && sum <= budget){
             if(sum + d[idx] <= budget){
                 count ++;
                 sum += d[idx];
             }else{
                 break;
             }
             idx++;
         }
        
        return count;
    }
}