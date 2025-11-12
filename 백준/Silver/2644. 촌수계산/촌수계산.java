import com.sun.source.tree.BreakTree;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i<=n;i++){
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int targetX = Integer.parseInt(st.nextToken());
        int targetY = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());


        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

//        System.out.println(graph);
        System.out.println(bfs(targetX,targetY));
    }

    static class Node {
        int idx;
        int level;

        Node(int idx,int level){
            this.idx = idx;
            this.level = level;
        }
    }

    static int bfs(int idx,int targetY){
        Node findNode = null;
        int answer = 0;
        LinkedList<Node> queue = new LinkedList<>();
        queue.push(new Node(idx,0));
        visited[idx] = true;

        while(!queue.isEmpty()){
            Node now = queue.pop();
            if(now.idx == targetY){
                findNode = now;
                break;
            }

            answer++;
            visited[now.idx] = true;

            List<Integer> link = graph.get(now.idx);
            for(int e : link){
                if(visited[e]) continue;
                queue.add(new Node(e,now.level+1));
            }
        }

        if(findNode != null){
            return findNode.level;
        }

        return -1;
    }
}
