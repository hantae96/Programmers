import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;

        List<String> visited = new ArrayList<>();
        int nowX = 0;
        int nowY = 0;
        
        for(char c : dirs.toCharArray()){
            int nextX = 0;
            int nextY = 0;
            if(c == 'U'){
                nextY = nowY + 1;
                nextX = nowX;
            }else if(c == 'L'){
                nextX = nowX - 1;
                nextY = nowY;
            }else if(c == 'R'){
                nextX = nowX +1;
                nextY = nowY;
                
            }else if(c == 'D'){
                nextY = nowY - 1;
                nextX = nowX;
            }
            
            if(nextX < -5 || nextX > 5 || nextY < -5 || nextY > 5){
                continue;
            }
            
            
            String right =  "" + nowX + nowY + nextX + nextY;
            String left = "" + nextX + nextY + nowX + nowY;
            
            
            
            if(!visited.contains(right) && !visited.contains(left)){
                System.out.println(c);
                answer++;
                visited.add(right);
                visited.add(left);
            }
            
            nowX = nextX;
            nowY = nextY;
        }
            
        return answer;
    }
}