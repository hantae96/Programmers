import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;

        while(n > 0){
            if(n == 1){
                ans++;
                n--;
                continue;
            }
            
            // 순간이동이 가능하면
            if(n%2 == 0){
                n = n/2;
            }else{
                ans++;
                n--;
            }
        }

        return ans;
    }
}