import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] count = new int[N+2];

        HashMap<Integer, Double> map = new HashMap<>();
        
        // 각 스테이지에 머물고 있는 사람의 수를 센다
        for (int stage : stages) {
            if (stage <= N) {
                count[stage]++;
            }
        }

        int total = stages.length;

        // 각 스테이지의 실패율을 계산한다
        for (int i = 1; i <= N; i++) {
            if (total == 0) {
                map.put(i, 0.0);
            } else {
                map.put(i, (double)count[i] / total);
                total -= count[i];
            }
        }

        // 실패율을 기준으로 스테이지를 정렬한다
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
            
        return keySet.stream().mapToInt(Integer::intValue).toArray();
    }
}