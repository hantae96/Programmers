import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        List<Integer> list = new ArrayList<>();
        String[] arr = s.split(" ");
        
        for(String str : arr){
            list.add(Integer.parseInt(str));
        }
        
        int max = Collections.max(list);
        int min = Collections.min(list);
        
        
        return min + " " + max;
    }
}