import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int teamAScore = 0;
        int teamBScore = 0;
        int teamASecond = 0;
        int teamBSecond = 0;

        int prev = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int teamId = Integer.parseInt(st.nextToken());
            int second = convertSecond(st.nextToken());

            if (teamAScore > teamBScore)
                teamASecond += (second - prev);
            else if (teamAScore < teamBScore)
                teamBSecond += (second - prev);

            if (teamId == 1)
                teamAScore++;
            else
                teamBScore++;

            prev = second;
        }

        if (teamAScore > teamBScore) {
            teamASecond += (convertSecond("48:00") - prev);
        } else if (teamAScore < teamBScore) {
            teamBSecond += (convertSecond("48:00") - prev);
        }

        System.out.printf("%s\n", convertFormat(teamASecond));
        System.out.printf("%s",convertFormat(teamBSecond));



    }
    
    static String convertFormat(int second) {
        return String.format("%02d:%02d", second / 60, second % 60);
    }


    static int convertSecond(String input) {
        int second = 0;
        String[] split = input.split(":");
        second += Integer.parseInt(split[0]) * 60;
        second += Integer.parseInt(split[1]);

        return second;
    }
}