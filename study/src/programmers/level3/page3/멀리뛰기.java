package programmers.level3.page3;

import java.util.*;
import java.lang.*;

public class 멀리뛰기 {

    public static void main(String[] args) {
        int n1 = 4;
        int n2 = 3;

        System.out.println(solution(n1));
        System.out.println(solution(n2));

    }

    public static long solution(int n) {
        long answer = 0;

        long[] dp = new long[2001];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i < 2001; i++)
        {
            dp[i] = dp[i-1]%1234567 + dp[i-2]%1234567;
        }

        answer = dp[n]%1234567;


        return answer;
    }

}
