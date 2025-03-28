import java.util.*;

class Solution {
    static String convert(int x, int y){
        return x + "" + y + "";
    }
    
    static boolean check(int num){
        if(num < -5 || num > 5){
            return false;
        }
        return true;
    }
    
    public int solution(String dirs) {
        int answer = 0;
        
        ArrayList<String> list = new ArrayList<>();
        
        int x = 0;
        int y = 0;
        int nx = 0;
        int ny = 0;
        for(char c : dirs.toCharArray()){
            boolean flag = true;
            if(c == 'U'){
                if(check(y+1)){
                    ny = y+1;
                }else{
                    flag = false;
                }
            }
            if(c == 'L'){
                if(check(x-1)){
                    nx = x-1;
                }else{
                    flag = false;
                }
            }
            if(c == 'R'){
                if(check(x+1)){
                    nx = x+1;
                }else{
                    flag = false;
                }
            }
            if(c == 'D'){
                if(check(y-1)){
                    ny = y-1;
                }else{
                    flag = false;
                }
            }
            

            if(!flag){
                continue;
            }
            
            String path = convert(x,y) + convert(nx,ny);
            String path2 = convert(nx,ny) + convert(x,y);
            
            
            if(!list.contains(path) && !list.contains(path2)){
                answer++;
            }
            
            list.add(path);
            list.add(path2);
            x = nx;
            y= ny;
        }
        
        
        return answer;
    }
}