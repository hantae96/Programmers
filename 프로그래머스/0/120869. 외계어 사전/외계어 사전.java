import java.util.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 0;
        
        for(String word : dic){
            boolean flag = true;
            for(String s : spell){
                if(!word.contains(s)){
                    flag = false;
                }
            }
            
            if(flag) return 1;
        }
        
        
        return 2;
    }
}