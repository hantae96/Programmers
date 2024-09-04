import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        
        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();
        
        
        for(int i = 0;i<cards1.length;i++){
            q1.add(cards1[i]);    
        }
        
        
        for(int i = 0;i<cards2.length;i++){
            q2.add(cards2[i]);    
        }
        
        for(int i = 0;i<goal.length;i++){
            String temp = goal[i];
            String top1 = q1.peek() == null ? "" : q1.peek();
            String top2 = q2.peek() == null ? "" : q2.peek();
            
            
            if(top1.equals(temp)){
                q1.remove();
            }else if(top2.equals(temp)){
                q2.remove();
            }else{
                return "No";
            }
        }
        
        return "Yes";
    }
}