
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        for(int i = 0;i<n;i++){
            int x = Integer.parseInt(br.readLine());
            list.add(x);
        }

        Collections.sort(list);

        for(int i = 0;i<n;i++){
            System.out.println(list.get(i));
        }
    }
}