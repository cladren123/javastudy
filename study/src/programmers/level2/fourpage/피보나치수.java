package programmers.level2.fourpage;

import java.util.*;

public class 피보나치수 {

    public static void main(String[] args) {

        int n1 = 3;
        int n2 = 5;

        System.out.println(solution(n1));
        System.out.println(solution(n2));

    }

    public static int solution(int n) {
        int answer = 0;

        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++)
            dp[i] = dp[i-1] % 1234567 + dp[i-2] % 1234567;

        answer = dp[n] % 1234567;

        // System.out.println(Arrays.toString(dp));


        return answer;
    }



}
