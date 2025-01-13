import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        // 무거운사람+가벼운사람 조합으로 그리디
        int min = 0;
        int max = people.length-1;
        
        while(min<=max){
            int sum = people[max];
            max--;
            answer++;
            int count = 1;
            
            while(sum + people[min] <= limit && count <2){
                sum += people[min];
                min++;
                count++;
                
            }
        }
        
        return answer;
    }
}