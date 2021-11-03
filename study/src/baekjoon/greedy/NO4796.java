package baekjoon.greedy;

import java.util.*;
import java.lang.*;
import java.io.*;

// 백준 4796 캠핑

public class NO4796 {

    public static void main(String[] args) {

        // 입력단
        Scanner scan = new Scanner(System.in);

        int number = 0;

        int l = scan.nextInt();
        int p = scan.nextInt();
        int v = scan.nextInt();

        while(!(l==0 && p==0 && v==0))
        {

            number += 1;

            // 계산
            int answer = 0;
            int count = v / p;

            answer += count * l;
            v = v - (count * p);
            v = Math.min(v, l);
            answer += v;
            System.out.printf("Case %d: %d", number, answer);
            System.out.println();

            l = scan.nextInt();
            p = scan.nextInt();
            v = scan.nextInt();

        }
    }
}
