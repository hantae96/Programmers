import java.io.*;
import java.util.*;

public class Main {
    static int k;
    static HashMap<Integer,Boolean> visited = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        System.out.println(findSubin(n));

    }


    static class Node{
        int idx;
        int day;

        public Node(int idx,int day){
            this.idx = idx;
            this.day = day;
        }
    }

    static int findSubin(int startIdx){
        boolean[] visited = new boolean[200001];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startIdx, 0));
        visited[startIdx] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.idx == k) return node.day;

            int nextDay = node.day + 1;

            // 범위 체크 + 방문 체크
            if(node.idx - 1 >= 0 && !visited[node.idx - 1]){
                visited[node.idx - 1] = true;
                queue.add(new Node(node.idx - 1, nextDay));
            }

            if(node.idx + 1 <= 100000 && !visited[node.idx + 1]){
                visited[node.idx + 1] = true;
                queue.add(new Node(node.idx + 1, nextDay));
            }

            if(node.idx * 2 <= 100000 && !visited[node.idx * 2]){
                visited[node.idx * 2] = true;
                queue.add(new Node(node.idx * 2, nextDay));
            }
        }
        return -1;
    }
}