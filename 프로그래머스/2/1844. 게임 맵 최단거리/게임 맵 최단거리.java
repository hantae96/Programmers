import java.util.*;


class Solution {
    static int[] dx = new int[]{-1,1,0,0};
    static int[] dy = new int[]{0,0,-1,1};
    static int[][] maps;
    static boolean[][] visited;
    public int solution(int[][] maps) {
        this.maps = maps;
        this.visited = new boolean[maps.length][maps[0].length];
        
        return bfs();
    }
    
    static int bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,1}); // 맨처음에 1칸 세고 시작
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            
            if(now[0] == maps.length-1 && now[1] == maps[0].length -1){
                return now[2];
            }
            
            for(int i = 0;i<4;i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                
                if(0 > nx || nx >= maps.length || 0 > ny || maps[0].length <= ny) continue;
                if(visited[nx][ny]) continue;
                if(maps[nx][ny] == 0) continue;
                
                queue.offer(new int[]{nx,ny,now[2]+1});
                visited[nx][ny] = true;
            }
        }
        
        return -1;
        
    }
}