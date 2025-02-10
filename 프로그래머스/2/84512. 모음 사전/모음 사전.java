import java.util.*;

class Solution {
    public int solution(String word) {
        int answer = 1;
        
        TreeSet<String> treeSet = new TreeSet<>();
        char[] array = new char[]{'A','E','I','O','U'};
        
        for(int i = 0;i<array.length;i++){
            for(int a = 0;a<array.length;a++){
                for(int b = 0;b<array.length;b++){
                    for(int c = 0;c<array.length;c++){
                        for(int d = 0;d<array.length;d++){
                            for(int e = 0;e<array.length;e++){
                                String s = "" + array[a] + array[b] + array[c] + array[d] + array[e];
                                treeSet.add(s.substring(0,i+1));
                            }
                        }
                    }
                }
            }
        }
        
        for(String w : treeSet){
            if(word.equals(w)){
                return answer;
            }
            answer++;
        }
                
        return answer;
    }
}