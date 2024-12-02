import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<numbers.length;i++){
            for(int j = i+1;j<numbers.length;j++){
                int num = numbers[i] + numbers[j];
                
                if(!list.contains(num)){
                    list.add(num);
                }
            }
        }

        Collections.sort(list);
        answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}