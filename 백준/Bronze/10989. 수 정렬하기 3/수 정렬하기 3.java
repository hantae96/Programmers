import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        // 입력과 출력을 버퍼로 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 숫자의 범위에 맞는 배열 생성
        int[] arr = new int[10000001];  // 최대 10,000,000까지 처리할 수 있도록 배열 설정

        // 입력 처리
        int n = Integer.parseInt(br.readLine());

        // 배열에 숫자의 빈도를 기록
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[num]++;
        }

        // 정렬된 결과 출력
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > 0) {
                bw.write(i + "\n");  // 출력은 BufferedWriter를 통해 빠르게 처리
                arr[i]--;
            }
        }

        // 모든 출력을 버퍼에서 한 번에 출력
        bw.flush();

        // 리소스 정리
        bw.close();
        br.close();
    }
}