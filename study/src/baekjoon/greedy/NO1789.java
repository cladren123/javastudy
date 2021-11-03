package baekjoon.greedy;

import java.util.*;
import java.lang.*;
import java.io.*;

// 백준 1789 수들의 합

/*
 1부터 sum에 하나씩 더해간다.
 sum이 주어진 수보다 크면 -1을 한다.
 예시 50
 1 2 3 4 5 6 7 8 9 10 = 55
 55에 5를 빼면 50
 입력값에 범위가 넓기 때문에 Long타입으로 받아야 한다.

 */


public class NO1789 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        long s = scan.nextLong();

        long start = 1;
        long sum = 0;
        long answer = 0;

        while(!(sum > s))
        {
            sum += start;
            start++;
            answer += 1;
        }
        answer -= 1;
        System.out.print(answer);
    }

}
