import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next().toLowerCase();

        HashMap<String,Integer> count = new HashMap<>();

        for(int i = 0;i<input.length();i++){
            String key = String.valueOf(input.charAt(i));
            Integer value = count.get(key);
            count.put(key,count.getOrDefault(key,0)+1);
        }

        Iterator iterator = count.keySet().iterator();
        int max = 0;
        String answer = "";

        for(String key : count.keySet()){
            if(count.get(key) > max){
              max = count.get(key);
              answer = key;
            }else if (count.get(key) == max){
                answer = "?";
            }
        }

        System.out.println(answer.toUpperCase());
    }
}