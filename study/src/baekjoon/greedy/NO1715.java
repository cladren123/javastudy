package baekjoon.greedy;

import java.util.*;
import java.lang.*;
import java.io.*;

// 백준 1715 카드 정렬하기

public class NO1715 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] card = new int[n];

        for(int i = 0; i < n; i++)
        {
            card[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(card);

        int answer = 0;

        int[] dp = new int[n];

    }
}
