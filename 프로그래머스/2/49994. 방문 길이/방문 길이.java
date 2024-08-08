// package org.zerock;

import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;

        HashSet<String> visited = new HashSet<>();

        int x = 0, y = 0, nx = 0, ny = 0;
        for(int i = 0;i<dirs.length();i++){
            char command = dirs.charAt(i);
            if(command == 'U'){
                nx = x;
                ny = y + 1;
            }else if(command == 'D'){
                nx = x;
                ny = y - 1;
            }else if(command == 'L'){
                nx = x - 1;
                ny = y;
            }else if(command == 'R') {
                nx = x + 1;
                ny = y;
            }


            if(nx < -5 || nx > 5 || ny < -5 || ny > 5){
                continue;
            }

            String leftPath = x + " " + y + " -> " + nx + " " + ny;
            String rightPath = nx + " " + ny + " -> " + x + " " + y;

            if(!visited.contains(leftPath) && !visited.contains(rightPath)){
                answer++;
            }


            visited.add(leftPath);
            visited.add(rightPath);

            x = nx;
            y = ny;
        }
        return answer;
    }}
