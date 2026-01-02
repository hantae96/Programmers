import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int total = brown + yellow;
        
        List<Integer> list = new ArrayList<>();
        for(int i = 1;i<=yellow;i++){
            if(yellow % i == 0){
                list.add(i);
            }
        }
        
        System.out.println(list);
        
        int lp = 0;
        int rp = list.size() -1;
        
        while(lp <= rp){
            int guessBrown = (list.get(lp) * 2) + (list.get(rp) * 2) + 4;
            if(guessBrown == brown){
                answer[0] = list.get(rp) + 2;
                answer[1] = list.get(lp) + 2;
                return answer;
            }
            
            lp++;
            rp--;
        }
        
        
        return answer;
    }
}