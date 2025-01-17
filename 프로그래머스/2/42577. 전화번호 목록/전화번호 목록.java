import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String, Boolean> map = new HashMap<>();

        // 1. 모든 전화번호를 맵에 삽입
        for (String number : phone_book) {
            map.put(number, true);
        }

        // 2. 접두어 탐색
        for (String number : phone_book) {
            for (int i = 1; i < number.length(); i++) {
                String prefix = number.substring(0, i); // 접두어 추출
                if (map.containsKey(prefix)) {
                    return false; // 접두어 관계 발견
                }
            }
        }

        return true; // 접두어 관계 없음
    }
}