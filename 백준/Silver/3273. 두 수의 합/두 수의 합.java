import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int n = Integer.parseInt(br.readLine());

       if(n == 1){
           System.out.println(0);
           return;
       }

       StringTokenizer st = new StringTokenizer(br.readLine());
       ArrayList<Integer> list = new ArrayList<>();

       for(int i = 0;i< n ;i++){
           list.add(Integer.parseInt(st.nextToken()));
       }

       int target = Integer.parseInt(br.readLine());

       list.sort(null);

       int lp = 0;
       int rp = n-1;
       int answer = 0;

       while(lp < rp){
           int sum = list.get(lp) + list.get(rp);
           if(sum == target){
               answer++;
               lp++;
           }
           else if(sum < target){
               lp++;
           }
           else{
               rp--;
           }
       }

        System.out.println(answer);

    }
}