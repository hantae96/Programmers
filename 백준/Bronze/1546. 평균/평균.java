import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        ArrayList<Integer> list = new ArrayList<Integer>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;i<n;i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        int max = Collections.max(list);
        int sum = list.stream().mapToInt(Integer::intValue).sum();

        System.out.println(sum * 100.0 / max/ n);
    }
}