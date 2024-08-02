import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        
        int [] one = new int[]{1,2,3,4,5};
        int [] two = new int[]{2,1,2,3,2,4,2,5};
        int [] three = new int[]{3,3,1,1,2,2,4,4,5,5};
        
        
        int[] count = new int[3];
        
        for(int i = 0;i<answers.length;i++){
            int oneIndex = i%(one.length);
            int twoIndex = i%(two.length);
            int threeIndex = i%(three.length);
            
            if(answers[i] == one[oneIndex]){
                count[0]++;
            }
            if(answers[i] == two[twoIndex]){
                                count[1]++;
            }
            if(answers[i] == three[threeIndex]){
                count[2]++;
            }  
        }
        
        int max = -1;
        for(int i = 0;i<3;i++){
            if(max < count[i]){
                max = count[i];
            }
        }

        List<Integer> temp = new ArrayList<>();
        for(int i = 0;i<3;i++){
            if(max == count[i]){
                temp.add(i+1);
            }
        }

        
        
        return temp.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}