import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] playersAtStage = new int[N + 2];  // N + 1개의 스테이지, 인덱스 1 기반으로 하나 추가

        // 각 스테이지에 머물러 있는 플레이어 수를 카운트
        for (int stage : stages) {
            playersAtStage[stage]++;
        }

        int totalPlayers = stages.length;
        Map<Integer, Double> failureRates = new HashMap<>();

        // 각 스테이지의 실패율을 계산
        for (int i = 1; i <= N; i++) {
            if (totalPlayers > 0) {
                double failureRate = (double) playersAtStage[i] / totalPlayers;
                failureRates.put(i, failureRate);
                totalPlayers -= playersAtStage[i];  // 남은 플레이어 수를 업데이트
            } else {
                failureRates.put(i, 0.0);  // 해당 스테이지에 도달한 플레이어가 없는 경우
            }
        }

        // 실패율을 기준으로 스테이지를 내림차순으로 정렬
        List<Integer> sortedStages = failureRates.keySet().stream()
                .sorted((a, b) -> failureRates.get(b).compareTo(failureRates.get(a)))
                .collect(Collectors.toList());

        // List를 int[]로 변환하여 반환
        return sortedStages.stream().mapToInt(Integer::intValue).toArray();
    }
}