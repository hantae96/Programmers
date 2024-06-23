import java.lang.Math;

class Solution {
    public long solution(long n) {
        double sqrt = Math.sqrt(n);
        
        if (sqrt == (long)sqrt) {
            return (long)Math.pow((long)(sqrt + 1), 2);
        } else {
            // 정수가 아니라면 -1을 반환합니다.
            return -1;
        }
    }
}