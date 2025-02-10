class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int next = n+1;
        while(true){
            String b1 = Integer.toBinaryString(n);
            String b2 = Integer.toBinaryString(next);
            if(count(b1) == count(b2)){
                break;
            }
            next++;
        }
        
        return next;
    }
    
    public int count(String bi){
        int count = 0;
        for(int i = 0;i<bi.length();i++){
            if(bi.charAt(i) == '1'){
                count++;
            }
        }
        return count;
    }
}