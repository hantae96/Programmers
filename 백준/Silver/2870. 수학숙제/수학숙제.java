
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 받기 (BufferedReader 사용)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        // 추출한 숫자를 저장할 리스트 (BigInteger로 처리)
        List<BigInteger> numbers = new ArrayList<>();
        
        // n줄에 대해 처리
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            // StringBuilder를 이용해 연속된 숫자를 누적
            StringBuilder sb = new StringBuilder();
            
            // 한 글자씩 확인
            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);
                // 숫자이면 누적
                if (Character.isDigit(c)) {
                    sb.append(c);
                } else {
                    // 만약 숫자를 누적 중이었다면, 끝난 것으로 간주하여 추가
                    if (sb.length() > 0) {
                        // BigInteger는 앞의 0을 자동 제거
                        numbers.add(new BigInteger(sb.toString()));
                        sb.setLength(0);  // 누적 초기화
                    }
                }
            }
            // 만약 라인이 숫자로 끝났다면 sb에 남아있으므로 추가
            if (sb.length() > 0) {
                numbers.add(new BigInteger(sb.toString()));
            }
        }
        
        // 리스트 오름차순(비내림차순) 정렬
        Collections.sort(numbers);
        
        // 출력 (BufferedWriter 사용하여 속도 개선)
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (BigInteger num : numbers) {
            bw.write(num.toString());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}