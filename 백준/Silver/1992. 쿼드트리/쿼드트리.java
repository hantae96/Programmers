import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    static int [][] map;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        map = new int[n][n];

        for(int j = 0;j<n;j++){
            String input = sc.nextLine();
            for(int i = 0;i<n;i++){
                map[j][i] = Character.getNumericValue(input.charAt(i));
            }
        }

        int[] startPos = new int[]{0, 0};

        divide(startPos, n);
    }

    public static void divide(int[] startPos, int size) {

        if(size == 1){
            System.out.print(map[startPos[0]][startPos[1]]);
            return;
        }

        int temp = 0;
        for(int y = startPos[0]; y < startPos[0] + size; y++){
            for(int x = startPos[1]; x < startPos[1] + size; x++){
                temp += map[y][x];
            }
        }

        if(temp == 0 || temp == size*size){
            System.out.print(map[startPos[0]][startPos[1]]);
            return;
        }

        System.out.print("(");
        divide(new int[]{startPos[0], startPos[1]}, size / 2);
        divide(new int[]{startPos[0], startPos[1] + size / 2}, size / 2);
        divide(new int[]{startPos[0] + size / 2, startPos[1]}, size / 2);
        divide(new int[]{startPos[0] + size / 2, startPos[1] + size / 2}, size / 2);
        System.out.print(")");
    }
}