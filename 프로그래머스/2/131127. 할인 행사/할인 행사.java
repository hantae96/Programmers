import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int limit = 10;

        // 원하는 상품과 그 수량을 맵에 저장
        HashMap<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        // 슬라이딩 윈도우 방식으로 10일 동안의 할인 항목을 확인
        for (int i = 0; i <= discount.length - limit; i++) {
            // 매번 새로운 복사본을 사용
            HashMap<String, Integer> tempMap = new HashMap<>(wantMap);
            boolean isValid = true;

            // 10일 동안의 할인 항목을 확인
            for (int j = i; j < i + limit; j++) {
                String elem = discount[j];
                
                if (!tempMap.containsKey(elem)) {
                    isValid = false;
                    break;
                }

                int value = tempMap.get(elem);
                if (value == 0) {
                    isValid = false;
                    break;
                } else {
                    tempMap.put(elem, value - 1);
                }
            }

            // 모든 조건을 만족하는 경우에만 answer 증가
            if (isValid) {
                answer++;
            }
        }

        return answer;
    }
}