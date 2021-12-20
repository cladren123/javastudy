package programmers.level3.page1;

public class twoxn타일링 {

    public static void main(String[] args) {

        int n = 4;
        System.out.println(solution(n));

    }


    public static int solution(int n) {
        int answer = 0;

        int[] dp = new int[60001];

        dp[1] = 1;
        dp[2] = 2;

        int num = 1000000007;

        for(int i = 3; i < n+1; i++)
        {
            dp[i] = dp[i-1]%num + dp[i-2]%num;
        }

        answer = dp[n]%num;




        return answer;
    }


}
