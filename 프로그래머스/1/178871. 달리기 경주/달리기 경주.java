import java.util.*;


class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        
        HashMap<String,Integer> map = new HashMap<>();
        HashMap<Integer,String> seqMap = new HashMap<>();
        for(int i = 0;i<players.length;i++){
            map.put(players[i],i+1);
            seqMap.put(i+1,players[i]);
        }
        
        for(String callingName : callings){
            int callingSeq = map.get(callingName);
            
            String frontName = seqMap.get(callingSeq-1); 
            
            map.put(callingName,callingSeq-1);
            seqMap.put(callingSeq-1,callingName);
            
            map.put(frontName,callingSeq);
            seqMap.put(callingSeq,frontName);
        }
        
        
        for(int i = 0;i<players.length;i++){
            answer[i] = seqMap.get(i+1);
        }
        
        return answer;
    }
    
}