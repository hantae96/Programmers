import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 장르별 곡 정보 저장: int[] = {인덱스, 재생 수}
        HashMap<String, List<int[]>> map = new HashMap<>();
        // 장르별 총 재생 수 저장
        HashMap<String, Integer> genrePlayCount = new HashMap<>();

        int count = genres.length;
        for (int i = 0; i < count; i++) {
            String genre = genres[i];
            int play = plays[i];
            List<int[]> songs = map.getOrDefault(genre, new ArrayList<>());
            songs.add(new int[]{i, play});
            map.put(genre, songs);
            genrePlayCount.put(genre, genrePlayCount.getOrDefault(genre, 0) + play);
        }

        // 장르별 총 재생 수를 기준으로 내림차순 정렬
        List<Map.Entry<String, Integer>> sortedGenres = new ArrayList<>(genrePlayCount.entrySet());
        sortedGenres.sort((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));

        List<Integer> answer = new ArrayList<>();

        // 장르별로 가장 많이 재생된 두 곡의 인덱스 찾기
        for (Map.Entry<String, Integer> genreEntry : sortedGenres) {
            String genre = genreEntry.getKey();
            List<int[]> songs = map.get(genre);

            // 재생 수 기준으로 내림차순 정렬
            songs.sort((s1, s2) -> Integer.compare(s2[1], s1[1]));

            // 두 곡만 선택 (곡이 두 개 미만일 경우, 가능한 곡만 선택)
            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                answer.add(songs.get(i)[0]);
            }
        }

        // 결과를 int[] 배열로 변환
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}