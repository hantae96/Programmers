import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] firstTeamData = new int[2]; // [스코어,합계분수]
        int[] secondTeamData = new int[2];

        boolean add = false;
        int winTeam = 0;
        String startTime = "";
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int teamId = Integer.parseInt(st.nextToken());
            String time = st.nextToken();

            // 점수 갱신
            if (teamId == 1) {
                firstTeamData[0] += 1;
            } else {
                secondTeamData[0] += 1;
            }

            if (i == 0) {
                startTime = time;
                winTeam = teamId;
                add = true;
                
            } else {
                if (firstTeamData[0] == secondTeamData[0]) {
                    if (winTeam == 1) {
                        firstTeamData[1] += convertMin(time) - convertMin(startTime);
                    } else {
                        secondTeamData[1] += convertMin(time) - convertMin(startTime);
                    }
                    winTeam = 0;
                    add = false;
                } else if (firstTeamData[0] > secondTeamData[0]) {
                    if (add) {
                        firstTeamData[1] += convertMin(time) - convertMin(startTime);    
                    }
                    
                    add = true;
                    winTeam = 1;
                    startTime = time;
                } else if (firstTeamData[0] < secondTeamData[0]) {
                    if (add) {
                        secondTeamData[1] += convertMin(time) - convertMin(startTime);    
                    }
                    
                    add = true;
                    winTeam = 2;
                    startTime = time;
                }
                
            }


            // 마지막일경우
            if (i == n - 1) {
                if (winTeam == 1) {
                    firstTeamData[1] += convertMin("48:00") - convertMin(startTime);
                } else if (winTeam == 2) {
                    secondTeamData[1] += convertMin("48:00") - convertMin(startTime);
                }
            }
        }

        System.out.println(convertHour(firstTeamData[1]));
        System.out.println(convertHour(secondTeamData[1]));
    }
    
    static String convertHour(int totalTime) {
        String value = "";

        int hour = totalTime / 60;
        int min = totalTime % 60;
        
        if (hour < 10) {
            value += "0" + hour;
        } else {
            value += hour;
        }

        value += ":";

        if (min < 10) {
            value += "0" + min;
        } else {
            value += min;
        }

        return value;
    }
    
 
    static int convertMin(String time) {
        int totalTime = 0;

        String[] temp = time.split(":");
        // System.out.println(Arrays.toString(temp));
        totalTime += Integer.parseInt(temp[0]) * 60;
        totalTime += Integer.parseInt(temp[1]);

        return totalTime;

    }
}