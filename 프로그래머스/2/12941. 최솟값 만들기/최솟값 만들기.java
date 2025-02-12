import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int n = A.length;
        
        for(int i = 0;i<n;i++){
            list1.add(A[i]);
            list2.add(B[i]);
        }
        
        Collections.sort(list1);
        Collections.sort(list2,Collections.reverseOrder());
        
        int i = 0;
        while(n > 0){
            answer += list1.get(i)*list2.get(i);
            i++;
            n--;
        }

        return answer;
    }
}