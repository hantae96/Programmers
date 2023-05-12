

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tmp = sc.next();
        int[] alpha = new int[26];
        Arrays.fill(alpha,-1);
        HashMap<Integer,Integer> check = new HashMap<>();


        for(int i =0;i<tmp.length();i++) {
            int elem = tmp.charAt(i);
            if (!check.containsKey(elem)) {
                check.put(elem, 1);
                alpha[tmp.charAt(i) - 'a'] = i;
            }

        }
        for(int i = 0;i<alpha.length;i++){
            System.out.printf(alpha[i] + " ");
        }
    }
}