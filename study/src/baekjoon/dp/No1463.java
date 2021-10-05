package baekjoon.dp;

import java.util.*;
import java.lang.*;
import java.io.*;

// 1463 1로 만들기

public class No1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine());

        int dp[] = new int[number+1];

        dp[0] = 0;
        dp[1] = 0;

        for(int i = 2; i < number + 1; i++){
            // 1을 뺏을 경우
            dp[i] = dp[i-1] + 1;

            // 2로 나누어 떨어질 경우
            if(i%2==0) dp[i] = Math.min(dp[i], dp[i/2] + 1);

            // 3으로 나누어 떨어질 경우, 2로 나누어 떨어지는 경우도 고려해야하기 때문에 if 사용
            if(i%3==0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
        }

        System.out.println(dp[number]);
        br.close();

    }
}
