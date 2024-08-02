import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] numbers) {
        // HashSet을 사용하여 중복된 합을 제거
        HashSet<Integer> set = new HashSet<>();
        
        // 모든 쌍의 합을 HashSet에 추가
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        // HashSet을 List로 변환하고 정렬
        List<Integer> temp = set.stream()
                                .sorted()
                                .collect(Collectors.toList());
        
        // List를 int[] 배열로 변환
        int[] answer = temp.stream()
                           .mapToInt(Integer::intValue)
                           .toArray();
        
        return answer;
    }
}