class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            
            if(c == ' '){
                answer += ' ';
                continue;
            }
            
            char nextChar = ' ';
            if('a' <= c && c <= 'z'){
                if(c + n > 122){
                    nextChar = (char)((c+n) % 122 + 96);
                }else{
                    nextChar  =(char)(c+n);
                }
            }else{
                if(c + n > 90){
                    nextChar = (char)((c+n) % 90 + 64);
                }else{
                    nextChar  =(char)(c+n);
                }
            }
            
            
            answer += nextChar;
        }
        return answer;
    }
}