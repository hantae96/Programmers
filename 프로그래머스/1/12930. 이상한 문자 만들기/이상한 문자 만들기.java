class Solution {
    public String solution(String s) {
        String answer = "";
        
        int i = 0;
        while(i<s.length()){
            char ch = s.charAt(i);
            if(ch == ' '){
                answer += ' ';
                i++;
                continue;
            }else{
                int j = 0;
                while(i+j < s.length() &&s.charAt(i+j) != ' '){
                    if(j%2 == 0){
                        answer += Character.toUpperCase(s.charAt(i+j));
                    }else{
                        answer += Character.toLowerCase(s.charAt(i+j));
                    }
                    j++;
                }
                i = j+i;
            }
        }
        
        
        return answer;
    }
}