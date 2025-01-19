import java.util.*;

class Solution {
    public int solution(int[] toppings) {
        int answer = 0;
        
        HashSet<Integer> brotherSet = new HashSet<>();
        int[] countArr = new int [10001];
                
        for(Integer topping : toppings){
            countArr[topping] = ++countArr[topping];
        }
        
        int size = 0;
        for(int count : countArr){
            if(count > 0){
                size++;
            }
        }
        
        
        for(int i = 0;i<toppings.length -1;i++){
            int value = toppings[i];
            brotherSet.add(value);
            
            if(--countArr[value] < 1){
                size--;
            }
            
            if(brotherSet.size() == size){
                answer++;
            }
        }
        
        return answer;
    }
}