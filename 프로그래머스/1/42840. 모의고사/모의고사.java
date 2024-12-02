import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        
        int a = 0;
        int b = 0;
        int c = 0;
        
        
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(2,1,2,3,2,4,2,5));
        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(3,3,1,1,2,2,4,4,5,5));
        
        for(int i = 0;i<answers.length;i++){
            int aIdx = i%list1.size();
            int bIdx = i%list2.size();    
            int cIdx = i%list3.size();    

            if(list1.get(aIdx) == answers[i]){
                a++;
            }
            
            if(list2.get(bIdx) == answers[i]){
                b++;
            }
            
            if(list3.get(cIdx) == answers[i]){
                c++;
            }
        }
        
        List<Integer> list = new ArrayList<>(Arrays.asList(a,b,c));
        
        int max = -1;
        int maxIdx = -1;
        for(int i = 0;i<list.size();i++){
            if(max < list.get(i)){
                max = list.get(i);
                maxIdx = i;
            }
        }
        
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i<list.size();i++){
            if(list.get(i) == max){
                answer.add(i+1);
            }
        }
        
        
        Collections.sort(answer);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}