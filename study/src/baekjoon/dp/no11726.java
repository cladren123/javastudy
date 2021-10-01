package baekjoon.dp;

import java.util.*;
import java.lang.*;
import java.io.*;

// 백준 11726 2xn 타일링

public class no11726 {
    public static void main(String[] args) throws IOException{
        // 정수 하나를 입력받으면 StringTokenizer 생략해도 된다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[1001];
        Arrays.fill(dp, 0);

        dp[1] = 1;
        dp[2] = 2;

        if(n >= 3){
            for(int i = 3; i <= n; i++) {
                dp[i] = (dp[i-1] + dp[i-2])%10007;
            }
        }

        System.out.println(dp[n]%10007);
        
    }
}
