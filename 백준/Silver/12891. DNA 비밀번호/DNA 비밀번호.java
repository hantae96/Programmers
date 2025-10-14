import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        String dna = br.readLine();

        int answer = 0;

        // 기준 설정
        st = new StringTokenizer(br.readLine());
        int[] standard = new int[4];
        for(int i = 0;i<4;i++){
            standard[i] = Integer.parseInt(st.nextToken());
        }


        // 초기값 설정
        int[] temp = new int[4];
        for(int i = 0;i< p;i++){
            char c = dna.charAt(i);
            add(c,temp);
        }


        if(check(temp,standard)){
            answer++;
        }

        int sp = 0;
        int lp = p - 1;

        while(lp < s-1){
            lp++;
            add(dna.charAt(lp),temp);
            remove(dna.charAt(sp),temp);
            sp++;

            if(check(temp,standard)){
                answer++;
            }
        }


        System.out.println(answer);
    }

    static void add(char c, int[] temp){
        if(c == 'A')
            temp[0] += 1;
        if(c == 'C')
            temp[1] += 1;
        if(c == 'G')
            temp[2] += 1;
        if(c == 'T')
            temp[3] += 1;
    }

    static void remove(char c, int[] temp){
        if(c == 'A')
            temp[0] -= 1;
        if(c == 'C')
            temp[1] -= 1;
        if(c == 'G')
            temp[2] -= 1;
        if(c == 'T')
            temp[3] -= 1;
    }



    static boolean check(int[] temp, int[] standard){
        boolean isSame = true;
        for(int i = 0;i<temp.length;i++){
            if(temp[i] < standard[i]){
                isSame = false;
                break;
            }
        }

        return isSame;
    }
}