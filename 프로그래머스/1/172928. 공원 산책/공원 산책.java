import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int sizeX = park[0].length();
        int sizeY = park[1].length();
        
        HashMap<String,Integer[]> command = new HashMap<>();
        command.put("E",new Integer[]{0,1});
        command.put("W",new Integer[]{0,-1});
        command.put("N",new Integer[]{-1,0});
        command.put("S",new Integer[]{1,0});
        
        int [] start = new int[2];
        int[][] parkMap = new int[sizeX][sizeY];
        for(int i = 0;i<sizeX;i++){
            for(int j = 0;j<sizeY;j++){
                if(park[i].charAt(j) == 'S'){
                    start[0] = i;
                    start[1] = j;
                }
                
                parkMap[i][j] = park[i].charAt(j);
            }
        }
        
        for(String route : routes){
            String[] r = route.split(" ");
            Integer[] value = command.get(r[0]);
            int nx = start[0] + value[0] * Integer.parseInt(r[1]);
            int ny = start[1] + value[1] * Integer.parseInt(r[1]);
            
            System.out.print(nx + " " + ny);
            System.out.println();
            
            if(0 > nx || nx >= sizeX || 0 > ny || ny >= sizeY) continue;
            
            int dx = nx - start[0];
            int dy = ny - start[1];
            
            // 횡이동일때
            boolean check = true;
            if(dx == 0){
                int[] arr = new int[]{start[1],ny};
                Arrays.sort(arr);
                
                for(int i = arr[0];i<=arr[1];i++){
                    if(parkMap[start[0]][i] == 'X'){
                        check = false;
                        break;
                    }
                }
            }
            
            // 종이동일때
            if(dy == 0){
                int[] arr = new int[]{nx,start[0]};
                Arrays.sort(arr);
                
                for(int i = arr[0];i<=arr[1];i++){
                    if(parkMap[i][start[1]] == 'X'){
                        check = false;
                        break;
                    }
                }
            }
        
            if(!check) continue;
            
            start[0] = nx;
            start[1] = ny;
            
        }   
        return start;
    }
}
