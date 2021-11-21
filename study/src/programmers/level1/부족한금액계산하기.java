package programmers.level1;

import java.util.*;
import java.lang.*;
import java.io.*;

public class 부족한금액계산하기 {

    public static void main(String[] args) {
        int price = 3;
        int money = 20;
        int count = 4;

        System.out.println(solution(price, money, count));

    }

    public static long solution(int price, int money, int count) {
        long answer = -1;

        long hap = 0;

        for(int i = 1; i <= count; i++)
        {
            hap += price * i;
        }

        answer = hap - money;
        if(answer < 0) answer = 0;

        return answer;
    }

}
