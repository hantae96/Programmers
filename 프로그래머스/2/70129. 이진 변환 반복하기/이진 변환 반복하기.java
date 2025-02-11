class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int zeroCount = 0;
        int count = 0;
        while(!s.equals("1")){
            
            count++;
            
            int originLength = s.length();
            s = s.replace("0","");
            int changeLength = s.length();
            
            zeroCount += originLength - changeLength;
            
            s = Integer.toBinaryString(changeLength);
            
        }
        
        answer[0] = count;
        answer[1] = zeroCount;
        return answer;
    }
    
    
}