class Solution {
    public int solution(int n, int m, int[] section) {
        
        int answer = 0;
        int idx = 0;
        int roler = 0;
        
        while(idx < section.length){
            if(roler < section[idx]){
                roler = section[idx] + (m-1);
                answer++;
            }else{
                idx++;
            }
        }
        
        return answer;
    }
}