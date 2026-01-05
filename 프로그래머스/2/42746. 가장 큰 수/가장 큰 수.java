import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // 문자열로 변환
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        
        // 정렬: "3", "30" → "330" vs "303" 비교
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
        
        // // 모두 0인 경우 처리
        if (arr[0].equals("0")) {
            return "0";
        }
        
        // 결합
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }
        
        return sb.toString();
    }
}