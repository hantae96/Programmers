import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int answer = 0;

        for (int i = 0; i < n; i++) {
            Stack<Character> stack = new Stack<>();
            String input = br.readLine();

            for (char c : input.toCharArray()) {
                if (stack.isEmpty()) {
                    stack.push(c);
                    continue;
                }

                if (stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }

            if (stack.isEmpty())
                answer++;

        }

        System.out.println(answer);
    }
}