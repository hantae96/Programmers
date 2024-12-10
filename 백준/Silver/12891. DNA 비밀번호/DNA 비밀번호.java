import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        String dna = br.readLine();
        int answer = 0;

        st = new StringTokenizer(br.readLine());

        HashMap<Character, Integer> required = new HashMap<>();
        required.put('A', Integer.parseInt(st.nextToken()));
        required.put('C', Integer.parseInt(st.nextToken()));
        required.put('G', Integer.parseInt(st.nextToken()));
        required.put('T', Integer.parseInt(st.nextToken()));

        HashMap<Character, Integer> current = new HashMap<>();
        current.put('A', 0);
        current.put('C', 0);
        current.put('G', 0);
        current.put('T', 0);

        // 초기 슬라이딩 윈도우 설정
        for (int i = 0; i < p; i++) {
            char c = dna.charAt(i);
            current.put(c, current.get(c) + 1);
        }

        // 조건 확인 함수
        if (isValid(required, current)) {
            answer++;
        }

        // 슬라이딩 윈도우 시작
        for (int i = p; i < s; i++) {
            char toAdd = dna.charAt(i); // 새로 추가할 문자
            char toRemove = dna.charAt(i - p); // 제거할 문자

            current.put(toAdd, current.get(toAdd) + 1);
            current.put(toRemove, current.get(toRemove) - 1);

            if (isValid(required, current)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    // 조건 확인 함수
    private static boolean isValid(HashMap<Character, Integer> required, HashMap<Character, Integer> current) {
        for (Character c : required.keySet()) {
            if (current.get(c) < required.get(c)) {
                return false;
            }
        }
        return true;
    }
}