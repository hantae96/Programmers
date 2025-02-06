import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[]{0,0};

        HashMap<String,Boolean> hashMap = new HashMap<>();
        
        for(String word : words){
            if(!hashMap.containsKey(word)){
                hashMap.put(word,true);
            }
        }
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            if(hashMap.get(word)){
                hashMap.put(word,false);
            }else{
                answer[0] = i%n + 1;
                answer[1] = i/n + 1;
                return answer;
            }
        }
        
        for(int i = 1;i<words.length;i++){
            String beforeWord = words[i-1];
            String nextWord = words[i];
            
            if(beforeWord.charAt(beforeWord.length()-1) != nextWord.charAt(0)){
                System.out.println(beforeWord);
                System.out.println(nextWord);
                answer[0] = i%n + 1;
                answer[1] = i/n + 1;

                return answer;
            }
        }
        
        
        

        return answer;
    }
}