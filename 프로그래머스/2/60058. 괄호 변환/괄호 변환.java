import java.util.*;

public class Solution {

    public String solution(String p) {
        return match(p);
    }

    //"()))((()"	
    static public String match(String input) {
        if(IsValid(input))
            return input;
        
        if (input.length() == 0)
            return "";

        String[] uvArr = split(input);
        
        if (IsValid(uvArr[0])) {
            return uvArr[0] + match(uvArr[1]);
        } else {
            String temp = "(";
            temp += match(uvArr[1]);
            temp += ")";

            String newU = "";
            for (int i = 1; i < uvArr[0].length() - 1; i++) {
                if (uvArr[0].charAt(i) == ')') {
                    newU += '(';
                } else {
                    newU += ')';
                }
            }

            return temp + newU;
        }
    }

    static boolean IsValid(String input) {
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            if (c == '(')
                stack.push(c);
            if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        return stack.isEmpty();
    }

    static String[] split(String input) {

        String[] splitArr = new String[2];

        int splitIdx = 0;
        int leftCount = 0;
        int rightCount = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(')
                leftCount++;
            if (input.charAt(i) == ')')
                rightCount++;

            splitIdx++;

            if (leftCount == rightCount) {
                splitArr[0] = input.substring(0, splitIdx);
                splitArr[1] = input.substring(splitIdx);
                break;
            }
        }

        return splitArr;
    }
}