import java.util.*;


class Node {
    int x;
    int y;
    int count;
    
    public Node(int x, int y,int count){
        this.x = x;
        this.y = y;
        this.count = count;
    }
}

class Solution {
    static boolean[][] visited;
    static char[][] maps;
    static int[] dx = new int[]{-1,1,0,0};
    static int[] dy = new int[]{0,0,-1,1};
    static int n,m;
    
    public int solution(String[] maps) {

        int answer = 0;
        this.n = maps.length;
        this.m = maps[0].length();
        this.maps = new char[n][m];
        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                this.maps[i][j] = maps[i].charAt(j);
            }            
        }
        
        Node lever = findLever();
        if(lever == null) return -1;
        
        return findExit(lever);
    }
    
    static int findExit(Node lever){
        visited = new boolean[n][m];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(lever);
        
        while(!queue.isEmpty()){
            Node now = queue.poll();
            if(maps[now.x][now.y] == 'E'){
                return now.count;
            }
            
            for(int i = 0;i<4;i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if(nx < 0|| nx >= n || ny < 0 || ny >= m) continue;
                if(visited[nx][ny]) continue;
                if(maps[nx][ny] == 'X') continue;
                
                visited[nx][ny] = true;
                queue.offer(new Node(nx,ny,now.count+1));
            }
        }
        
        return -1;
    }
    
    
    static Node findLever(){
        visited = new boolean[n][m];
        Queue<Node> queue = new LinkedList<>();

        Node start = null;
        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(maps[i][j] == 'S') start = new Node(i,j,0);
            }
        }
        
        queue.offer(start);
        visited[start.x][start.y] = true;
        
        while(!queue.isEmpty()){
            Node now = queue.poll();
            if(maps[now.x][now.y] == 'L'){
                return now;   
            }
            
            for(int i = 0;i<4;i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if(nx < 0|| nx >= n || ny < 0 || ny >= m) continue;
                if(visited[nx][ny]) continue;
                if(maps[nx][ny] == 'X') continue;
                
                visited[nx][ny] = true;
                queue.offer(new Node(nx,ny,now.count+1));
            }
            
        }
        
        return null;
            
        
        
    }
}