import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for(int i = 0;i<want.length;i++){
            String key = want[i];
            Integer value = number[i];
            map.put(key,value);                        
        }
        
        
        int startRange = discount.length - 9;
        for(int i = 0;i<startRange;i++){
            HashMap<String,Integer> temp = new HashMap<String,Integer>(map);
            boolean check = true;
            for(int j = i;j<i+10;j++){
                String key = discount[j];
                if(!temp.containsKey(key)){
                    check = false;
                    break;
                }
                int value = temp.get(key);
                if(value == 0){
                    check = false;
                    break;
                }
                temp.put(key,--value);
            }
            
            if(check){
                answer++;
            }
        }
        
        return answer;
    }
}