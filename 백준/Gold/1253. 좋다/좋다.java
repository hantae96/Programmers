import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) arr[i] = Long.parseLong(st.nextToken());

        Arrays.sort(arr);

        // n < 3이면 어떤 수도 두 수의 합으로 만들 수 없음
        if (n < 3) {
            System.out.println(0);
            return;
        }

        int answer = 0;

        // 각 i에 대해 arr[i]가 두 수의 합으로 표현 가능한지 검사
        for (int i = 0; i < n; i++) {
            long target = arr[i];
            int l = 0, r = n - 1;

            while (l < r) {
                // 자기 자신은 제외
                if (l == i) { l++; continue; }
                if (r == i) { r--; continue; }

                long sum = arr[l] + arr[r];

                if (sum == target) {
                    answer++;
                    break;               // 해당 i는 찾았으니 다음 i로
                } else if (sum < target) {
                    l++;                  // 더 크게
                } else {
                    r--;                  // 더 작게
                }
            }
        }

        System.out.println(answer);
    }
}