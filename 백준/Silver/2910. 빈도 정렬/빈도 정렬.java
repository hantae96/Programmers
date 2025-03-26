
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<n;i++){
            int num = Integer.parseInt(st.nextToken());
            int value = map.getOrDefault(num,0);
            map.put(num,value+1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return map.get(o2) - map.get(o1);
            }
        });


        for(int key : list) {
            for(int i=0;i<map.get(key);i++) {
                System.out.print(key+" ");
            }
        }
    }
}