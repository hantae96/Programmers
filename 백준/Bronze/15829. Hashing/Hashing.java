
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{

        HashMap<Character,Integer> hashMap = new HashMap<>();

        for(int i = 0; i<26;i++){
            hashMap.put((char)(97 + i),i+1);
        }
//        System.out.println(hashMap);

        BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sb.readLine());
        String input = sb.readLine();

        int answer = 0;
        for(int i = 0; i<input.length();i++){
            answer += (hashMap.get(input.charAt(i)) * (int)(Math.pow(31,i)));
        }

        System.out.println(answer % 1234567891);
    }
}