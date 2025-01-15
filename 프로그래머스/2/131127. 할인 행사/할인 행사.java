import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String,Integer> map = new HashMap<>();
        
        for(int i = 0;i<want.length;i++){
            map.put(want[i],number[i]);
        }
        
        
        for(int start = 0;start<=discount.length-10;start++){
            HashMap<String,Integer> copy = new HashMap<>(map);
            boolean flag = true;
            for(int i = start;i<start+10;i++){
                if(!copy.containsKey(discount[i])){
                    flag = false;
                    break;
                }
                
                int value = copy.get(discount[i]);
                copy.put(discount[i],--value);
            }
                        
            
            for(Map.Entry<String,Integer> entry : copy.entrySet()){
                if(entry.getValue() > 0){
                    flag = false;
                    break;
                }
            }
            
            if(flag){
                answer++;
            }
        }
        
        return answer;
    }
}