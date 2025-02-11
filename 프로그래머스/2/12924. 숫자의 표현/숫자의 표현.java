class Solution {
    public int solution(int n) {
        int answer = 1;
        
        
        for(int i = 1;i< n/2 + 1;i++){
            
            int sum = 0;
            int j = i;
            while(true){
                if (sum == n){
                    answer++;
                    break;
                }else if(sum < n){
                    sum += j;
                    j++;
                }else{
                    break;
                }
            }
        }
        return answer;
    }
}