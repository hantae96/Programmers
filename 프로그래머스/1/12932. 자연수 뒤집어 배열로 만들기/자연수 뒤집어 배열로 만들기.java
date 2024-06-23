import java.util.*;

class Solution {
    public int[] solution(long n) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        
        // 각 자리 숫자를 ArrayList에 추가
        while (n > 0) {
            answer.add((int) (n % 10));
            n = n / 10;
        }
        
        // ArrayList를 기본형 int 배열로 변환
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        
        return result;
    }
}