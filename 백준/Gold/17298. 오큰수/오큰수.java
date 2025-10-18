import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        // 🔁 결과를 위치별로 담아둘 배열
        String[] res = new String[n];

        // 맨 마지막 값의 오큰수는 기본적으로 -1
        res[n - 1] = "-1";
        stack.push(list.get(n - 1));

        for (int i = n - 2; i >= 0; i--) {
            if (!stack.isEmpty() && stack.peek() > list.get(i)) {
                res[i] = String.valueOf(stack.peek());
                stack.push(list.get(i));
            } else {
                while (!stack.isEmpty() &&  stack.peek() <= list.get(i)) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    res[i] = "-1";
                    stack.push(list.get(i));
                } else {
                    res[i] = String.valueOf(stack.peek());
                    stack.push(list.get(i));
                }
            }
        }

        // ✅ 한 번에 출력 (앞에 붙이지 않음)
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0) out.append(' ');
            out.append(res[i]);
        }
        System.out.println(out);
    }
}