import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            Stack<Character> stack = new Stack<>();

            for (char c : input.toCharArray()) {
                if (stack.isEmpty()) {
                    stack.add(c);
                } else {
                    if (stack.peek() == '(' && c == ')')
                        stack.pop();
                    else
                        stack.add(c);
                }
            }

            if (stack.isEmpty())
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        
    }
}