import java.util.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        for(String word : dic){
            int count = 0;
            for(String s : spell){
                if(word.contains(s)) count++;
            }
            
            if(count == spell.length){
                System.out.println(word);
                return 1;
            }
        }
        return 2;
    }
}