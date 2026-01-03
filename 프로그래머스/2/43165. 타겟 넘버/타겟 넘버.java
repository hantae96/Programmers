class Solution {
    static int answer,n,target;
    static int[] numbers;
    public int solution(int[] numbers, int target) {
        
        this.target = target;
        this.n = numbers.length;
        this.numbers = numbers;
        
        dfs(0,0);
        
        return answer;
    }
    
    
    static void dfs(int sum,int depth){
        if(depth == n){
            // System.out.println(sum);
            if(sum == target){
                answer++;
                return;
            }
            
            return;
        }
        
        dfs(sum + numbers[depth],depth+1);
        dfs(sum + (-1)*numbers[depth],depth+1);
    }
}