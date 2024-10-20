import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> genrePlayCount = new HashMap<>();
        HashMap<String, List<int[]>> genreSongMap = new HashMap<>();

        // 장르별 재생 수 합산 및 곡 정보 저장
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            // 장르별 총 재생 횟수 합산
            genrePlayCount.put(genre, genrePlayCount.getOrDefault(genre, 0) + play);

            // 장르별 곡 정보 저장 (재생 수와 인덱스)
            List<int[]> songs = genreSongMap.getOrDefault(genre, new ArrayList<>());
            songs.add(new int[]{play, i});
            genreSongMap.put(genre, songs);
        }

        // 장르별 재생 수 내림차순으로 정렬
        List<Map.Entry<String, Integer>> genreList = new ArrayList<>(genrePlayCount.entrySet());
        genreList.sort((entry1, entry2) -> Integer.compare(entry2.getValue(), entry1.getValue())); // 내림차순 정렬

        // 결과 배열 구성
        for (Map.Entry<String, Integer> entry : genreList) {
            String genre = entry.getKey();
            List<int[]> songs = genreSongMap.get(genre);

            // 곡 재생 수 내림차순 정렬 (동일 재생 수일 경우 인덱스 기준으로 정렬)
            songs.sort((a, b) -> {
                if (a[0] == b[0]) {
                    return Integer.compare(a[1], b[1]); // 인덱스 기준으로 정렬
                }
                return Integer.compare(b[0], a[0]); // 재생 수 기준으로 정렬
            });

            // 최대 두 곡 추가
            for (int j = 0; j < Math.min(2, songs.size()); j++) {
                answer.add(songs.get(j)[1]); // 인덱스를 추가
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}