import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        boolean capitalize = true;

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                answer.append(c);
                capitalize = true;
            } else {
                answer.append(capitalize ? Character.toUpperCase(c) : Character.toLowerCase(c));
                capitalize = false;
            }
        }

        return answer.toString();
    }
}