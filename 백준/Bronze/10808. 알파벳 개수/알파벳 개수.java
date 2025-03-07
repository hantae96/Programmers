import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] answer = new int[26];

        for(int i = 0;i<str.length();i++){
            int index = ((int)str.charAt(i)) - 97;
            answer[index] = ++answer[index];
        }

        for(int i : answer){
            System.out.print(i + " ");
        }
    }
}