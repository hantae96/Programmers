            

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        int[] alpha = new int[26];


        BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(sb.readLine());


        for (int i = 0; i < count; i++) {
            String input = sb.readLine();
            int index = (int) input.charAt(0) - 97;
            alpha[index] += 1;
        }



        boolean print = false;
        for (int j = 0; j < 26; j++) {
            if (alpha[j] > 4) {
                System.out.print((char)(j +97));
                print = true;
            }
        }

        if(!print){
            System.out.println("PREDAJA");
        }

    }
}