import java.util.*;

class Solution {
    static boolean[][] visited;
    static Node lever, start, end;
    static String[] maps;
    static int[] dx = new int[]{-1,1,0,0};
    static int[] dy = new int[]{0,0,-1,1};
    
    static class Node{
        int x;
        int y;
        int count;
        
        public Node(int x,int y,int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    
    public int solution(String[] maps) {
        int answer = 0;
        this.maps = maps;
        
        for(int i = 0;i<maps.length;i++){
            for(int j = 0;j<maps[i].length();j++){
                if(maps[i].charAt(j) == 'S'){
                    start = new Node(i,j,0);
                }
                
                if(maps[i].charAt(j) == 'E'){
                    end = new Node(i,j,0);
                }
                
                if(maps[i].charAt(j) == 'L'){
                    lever = new Node(i,j,0);
                }
            }
        }
        
        int leverCount = findNode(start,lever);
        if(leverCount == -1){
            return -1;
        }
        int exitCount = findNode(lever,end);
        if(exitCount == -1){
            return -1;
        }
        
        
        return leverCount + exitCount;
    }
    
    static int findNode(Node start, Node target){
        visited = new boolean[maps.length][maps[0].length()];
        
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(start);
        visited[start.x][start.y] = true;
        
        while(!queue.isEmpty()){
            Node now = queue.poll();
            
            if(now.x == target.x && now.y == target.y){
                return now.count;
            }
            
            for(int i = 0; i<4;i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if(0 > nx || maps.length <= nx || 0 > ny || maps[0].length() <= ny){
                    continue;
                }
                
                if(maps[nx].charAt(ny) == 'X'){
                    continue;
                }
                
                if(visited[nx][ny]){
                    continue;
                }
                
                visited[nx][ny] = true;
                queue.offer(new Node(nx,ny,now.count + 1));
            }
        }
        return -1;
    }
    
}