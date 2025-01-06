class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        
        int empty = n;
        while(empty >= a){
            int newCoke = (empty/a) * b;
            answer+= newCoke;
            
            empty = empty%a;
            empty += newCoke;
        }
        return answer;
    }
}