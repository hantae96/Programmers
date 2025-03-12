class Solution {
    public int solution(String s) {
        int answer = 1;

        int xCount = 1;
        int yCount = 0;
        
        char x = s.charAt(0);
        int idx = 1;
        while(idx<s.length()){
            if(xCount == yCount){
                answer++;
                
                x = s.charAt(idx);
                yCount = 0;
                xCount = 1;
                
            }else{
                if(x == s.charAt(idx)){
                    xCount++;
                }else{
                    yCount++;
                }
            }
                idx++;
        }
        
        return answer;
    }
}