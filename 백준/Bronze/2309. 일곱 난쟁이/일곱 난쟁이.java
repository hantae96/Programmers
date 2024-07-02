
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i<9; i++){
            list.add(Integer.parseInt(sc.nextLine()));
        }

        int sum = 0;
        for (int num : list){
            sum += num;
        }


        List<Integer> delete = new ArrayList<>();
        boolean flag = false;
        for(int i = 0;i<list.size();i++){
            if(flag) break;
            for(int j = i+1; j<list.size();j++){
                if(flag) break;
                    int temp = list.get(i) + list.get(j);
                    if(sum - temp == 100){
                        for(int t = 0; t<list.size();t++){
                            if(t != i && t != j){
                                delete.add(list.get(t));
                            }
                        }
                        flag = true;
                        break;
                    }
            }
        }

        Collections.sort(delete);

        for(int t : delete){
            System.out.println(t);
        }


    }


}