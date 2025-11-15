import java.io.*;
import java.util.*;

public class Main {
    static int k;
    static HashMap<Integer,Boolean> visited = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == 0 || b == 0 || c== 0)
                break;

            List<Integer> list = new ArrayList<>();
            list.add(a);
            list.add(b);
            list.add(c);

            list.sort(Collections.reverseOrder());
            if(list.get(0) >= list.get(1) + list.get(2)) {
                System.out.println("Invalid");
                continue;
            }

            if(a == b && a == c){
                System.out.println("Equilateral");
                continue;
            }

            if(a != b && b != c && a != c)
            {
                System.out.println("Scalene");
                continue;
            }

            System.out.println("Isosceles");


        }



    }
}