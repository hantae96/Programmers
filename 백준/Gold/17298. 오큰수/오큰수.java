import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        Deque<Integer> stack = new ArrayDeque<>(); // 인덱스 스택

        for (int i = 0; i < n; i++) {
            // 현재 값이 스택 top 인덱스의 값보다 크면, 그 인덱스의 오큰수는 현재 값
            while (!stack.isEmpty() && a[stack.peek()] < a[i]) {
                ans[stack.pop()] = a[i];
            }
            stack.push(i);
        }

        StringBuilder out = new StringBuilder(n * 3);
        for (int i = 0; i < n; i++) {
            if (i > 0) out.append(' ');
            out.append(ans[i]);
        }
        System.out.println(out);
    }
}