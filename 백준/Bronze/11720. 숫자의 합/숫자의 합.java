
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();

        String tmp = sc.next();
        int answer = 0;
        for (int i = 0;i<count;i++){
            answer += tmp.charAt(i)-'0';
        }
        System.out.println(answer);
    }
}