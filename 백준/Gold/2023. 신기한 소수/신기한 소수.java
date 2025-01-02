import java.util.Scanner;

public class Main {

    static int n;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 2; i < 10; i++) {
            if (checkPrimeNumber(i)) { // 한 자리 수 소수만 DFS 시작
                dfs(i, 1);
            }
        }
    }

    // 현재 숫자와 자릿수
    static void dfs(int number, int size) {
        if (size == n) { // n자리 수 도달 시 출력 후 종료
            System.out.println(number);
            return;
        }

        for (int i = 0; i < 10; i++) {
            int nextNumber = number * 10 + i; // 다음 자릿수 계산
            if (checkPrimeNumber(nextNumber)) { // 소수만 재귀 호출
                dfs(nextNumber, size + 1); // size+1로 올바르게 전달
            }
        }
    }

    // 소수 판별 함수
    static boolean checkPrimeNumber(int number) {
        if (number < 2) return false; // 1 이하 소수 아님
        for (int i = 2; i <= Math.sqrt(number); i++) { // 제곱근까지만 체크
            if (number % i == 0) return false; // 약수 존재하면 소수 아님
        }
        return true; // 소수
    }
}