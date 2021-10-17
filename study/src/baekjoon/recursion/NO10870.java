package baekjoon.recursion;

import java.util.*;
import java.io.*;
import java.lang.*;

public class NO10870 {

    public static void main(String[] args) throws IOException{
        // n의 범위는 20보다 작거나 같은 자연수
        int[] dp = new int[21];

        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i < 21; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(dp[n]);

    }
}
