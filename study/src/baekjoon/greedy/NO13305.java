package baekjoon.greedy;

import java.util.*;
import java.lang.*;
import java.io.*;

// 백준 13305 주유소
/*
다음에 만난 도시가 이전 도시보다 비싸면 이전 도시의 기름값으로 계산한다.

문제에서 주어진 범위가 크기 때문에 int 대신에 long을 사용해야 한다.
 */

public class NO13305 {

    public static void main(String[] args) {

        // 입력단
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long[] road = new long[n-1];
        for(int i = 0; i < (n-1); i++)
        {
            road[i] = scan.nextLong();
        }
        long[] city = new long[n];
        for(int i = 0; i < n; i++)
        {
            city[i] = scan.nextLong();
        }

        // 구현
        long answer = 0;
        long check = city[0];

        for(int i = 0; i < (n-1); i++)
        {
            check = Math.min(check, city[i]);
            answer += road[i] * check;
        }

        System.out.print(answer);

    }
}
