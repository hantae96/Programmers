
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());  // .trim()을 사용하여 공백 제거

        for (int j = 0; j < n; j++) {
            HashMap<String, ArrayList<String>> map = new HashMap<>();
            int m = Integer.parseInt(br.readLine().trim());  // .trim()을 사용하여 공백 제거

            for (int i = 0; i < m; i++) {
                String[] input = br.readLine().trim().split(" ");  // .trim()을 사용하여 공백 제거
                String value = input[0];
                String key = input[1];
                if (map.containsKey(key)) {
                    ArrayList<String> values = map.get(key);
                    values.add(value);
                } else {
                    ArrayList<String> values = new ArrayList<>();
                    values.add(value);
                    map.put(key, values);
                }
            }

            int res = 1;
            for (String key : map.keySet()) {
                int length = map.get(key).size();
                res *= (length + 1);
            }

            System.out.println(res -1);
        }

    }
}