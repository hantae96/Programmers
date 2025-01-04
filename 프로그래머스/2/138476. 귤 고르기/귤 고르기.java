import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<tangerine.length;i++){
            if(!map.containsKey(tangerine[i])){
                map.put(tangerine[i],1);
            }else{
                int value = map.get(tangerine[i]);
                
                map.put(tangerine[i],value+1);
            }
        }
        
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a,b) -> b.getValue().compareTo(a.getValue()));
        
        int count = k;
        for(Map.Entry<Integer,Integer> entry : list){
            if(count == 0){
                break;
            }
            
            if(entry.getValue() <= count){
                count -= entry.getValue();
                ++answer;
            }else{
                return ++answer;
            }
            
        }
        
        return answer;
    }
}