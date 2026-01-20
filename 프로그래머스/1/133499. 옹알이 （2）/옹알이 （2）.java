class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for (String bab : babbling) {
            // 연속 발음 체크
            if (bab.contains("ayaaya") || bab.contains("yeye") || 
                bab.contains("woowoo") || bab.contains("mama")) {
                continue;
            }
            
            // 발음 가능 단어 제거
            String temp = bab.replace("aya", " ")
                             .replace("ye", " ")
                             .replace("woo", " ")
                             .replace("ma", " ")
                             .replace(" ", "");
            
            // 모두 제거되었으면 발음 가능
            if (temp.isEmpty()) {
                answer++;
            }
        }
        
        return answer;
    }
}