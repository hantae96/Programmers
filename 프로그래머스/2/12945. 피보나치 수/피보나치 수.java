import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] dpArray = new int[n+1];
        
        dpArray[0] = 1;
        dpArray[1] = 1;
        
        int idx = 2;
        while(idx != n){
            dpArray[idx] = (dpArray[idx-1] + dpArray[idx-2])%1234567;
            idx++;
        }
        
        return dpArray[n-1];
    }
}