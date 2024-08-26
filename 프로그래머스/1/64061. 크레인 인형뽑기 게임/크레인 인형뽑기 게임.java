import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int move : moves){
            // System.out.println("move : "+ move);
            int idx = 0;
            int peek = -1;
            while(idx<board.length){
                if(board[idx][move-1] == 0){
                    idx++;
                    continue;
                }else{
                    peek = board[idx][move-1];
                    // 0으로 치환하는거 안함
                    board[idx][move-1] = 0;
                    break;
                }
            }
            
            // System.out.println(stack);
            if(stack.size() > 0){
                int top = stack.peek();
                if(peek != -1 && top == peek){
                    stack.pop();
                    answer+=2;
                    continue;
                }
            }
            
            stack.push(peek);
            
        }
        return answer;
    }
}