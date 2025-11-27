import java.util.*;

class Node {
    int x;
    int y;
    int count;
    public Node(int x, int y, int count){
        this.x = x;
        this.y = y;
        this.count = count;
    }
}

class Solution {
    
    static int[] dx = new int[]{-1,1,0,0};
    static int[] dy = new int[]{0,0,-1,1};
    static String[] maps;
    static boolean[][] visited;
    static Node start;
    static Node end;
    static Node lever;
    
    public int solution(String[] maps) {
        int answer = 0;
        
        this.maps = maps;
        visited = new boolean[maps.length][maps[0].length()];
        
        for(int i = 0;i<maps.length;i++){
            for(int j = 0; j<maps[0].length();j++){
                if(maps[i].charAt(j) == 'S'){
                    start = new Node(i,j,0);
                }else if(maps[i].charAt(j) == 'L'){
                    lever = new Node(i,j,0);
                }else if(maps[i].charAt(j) == 'E'){
                    end = new Node(i,j,0);
                }
            }
        }
        
        visited = new boolean[maps.length][maps[0].length()];
        int findLever = find(start,lever);
        if(findLever == - 1) return -1;
        
                visited = new boolean[maps.length][maps[0].length()];
        int findEnd = find(lever,end);
        if(findEnd == -1) return -1;
        
        return findLever + findEnd;
    }
    
    
    static int find(Node start, Node target){
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(start);
        visited[start.x][start.y] = true;
    
        boolean isLever = false;
        
        while(!queue.isEmpty()){
            Node now = queue.pop();
            if(now.x == target.x && now.y == target.y){
                return now.count;
            }
            
            for(int i = 0;i<4;i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if(0 > nx || nx >= maps.length || 0 > ny || ny >= maps[0].length()){
                    continue;
                }
                
                if(maps[nx].charAt(ny) == 'X') continue;
                if(visited[nx][ny]) continue;
               
                
                visited[nx][ny] = true;
                queue.add(new Node(nx,ny,now.count+1));
            }
        }
        
        return -1;
        
    }
}