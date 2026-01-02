import java.util.*;

class Solution {
    public long solution(long n) {
        
        Integer [] arr = new Integer[10];
        Arrays.fill(arr,-1);
        
        String number = n + "";
        for(int i = 0;i<number.length();i++){
            arr[i] = number.charAt(i) - '0';
        }
        
        Arrays.sort(arr,Collections.reverseOrder());
        
        String answer = "";
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == -1) continue;
            answer += (arr[i]+ "");
        }
        
        return Long.parseLong(answer);
    }
}