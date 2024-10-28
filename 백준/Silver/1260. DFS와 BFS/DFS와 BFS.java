

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int[] visited = new int[n+1];

        HashMap<Integer,List<Integer>> graph = new HashMap<>();


        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            // 양방향이므로 둘다 넣어줘야한다.
            List<Integer> temp = graph.getOrDefault(s,new ArrayList<>());
            temp.add(d);
            Collections.sort(temp); // 참조형식으로 바로 반영됨
            graph.put(s, temp);

            temp = graph.getOrDefault(d,new ArrayList<>());
            temp.add(s);
            Collections.sort(temp);
            graph.put(d, temp);
        }

        dfs(v,visited,graph);
        System.out.println();
        visited = new int[n+1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        bfs(queue,visited,graph);


    }


    static public void dfs(int node, int[] visited, HashMap<Integer, List<Integer>> graph) {
        if (visited[node] == 1) {
            return;
        }

        System.out.print(node + " ");
        visited[node] = 1;

        // graph.getOrDefault(node, new ArrayList<>()) 사용
        for (int elem : graph.getOrDefault(node, new ArrayList<>())) {
            dfs(elem, visited, graph);
        }
    }

    static public void bfs(Queue<Integer> queue, int[] visited, HashMap<Integer, List<Integer>> graph) {
        while (!queue.isEmpty()) {
            int node = queue.remove();
            if (visited[node] == 0) {
                visited[node] = 1;
                System.out.print(node + " ");
            }

            // graph.getOrDefault(node, new ArrayList<>()) 사용
            List<Integer> list = graph.getOrDefault(node, new ArrayList<>());
            for (int elem : list) {
                if (visited[elem] == 1) continue;
                queue.add(elem);
            }
        }
    }

}