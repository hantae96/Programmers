import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        List<Integer> sumList = new ArrayList<>();
        for(int i = 0;i<n;i++){
            int num = Integer.parseInt(st.nextToken());
            if(i == 0){
                sumList.add(num);
            }else{
                int sum = sumList.get(i -1) + num;
                sumList.add(sum);
            }
        }

        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if(start == 1){
                System.out.println(sumList.get(end-1));
            }else{
                System.out.println(sumList.get(end-1) - sumList.get(start-2));
            }
}

    }
}