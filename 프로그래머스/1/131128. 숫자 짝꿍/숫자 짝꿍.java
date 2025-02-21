import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        int[] countA = new int[10];
        int[] countB = new int[10];

        for (char c : X.toCharArray()) {
            countA[c - '0']++;
        }

        for (char c : Y.toCharArray()) {
            countB[c - '0']++;
        }

        List<Integer> combine = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int minCount = Math.min(countA[i], countB[i]);
            for (int j = 0; j < minCount; j++) {
                combine.add(i);
            }
        }

        if (combine.isEmpty()) return "-1";

        // 내림차순 정렬 (큰 숫자 만들기)
        combine.sort(Collections.reverseOrder());

        // "0" 예외 처리 (0만 포함된 경우)
        if (combine.get(0) == 0) return "0";

        // 숫자 조합 후 반환
        StringBuilder sb = new StringBuilder();
        for (int num : combine) {
            sb.append(num);
        }
        
        return sb.toString();
    }
}