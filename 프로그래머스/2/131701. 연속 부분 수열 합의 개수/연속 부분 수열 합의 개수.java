
import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();

        for(int length = 1;length<=elements.length;length++){
            for(int start = 0;start<elements.length;start++){

                int sum = 0;
                int count = length;
                int idx = start%elements.length;
                while(count > 0){
                    sum+=elements[idx];
                    count--;
                    idx = (idx+1)%elements.length;
                }
                set.add(sum);
            }
        }

        return set.size();
    }
}