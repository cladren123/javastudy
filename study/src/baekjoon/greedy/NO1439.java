package baekjoon.greedy;

import java.util.*;
import java.lang.*;
import java.io.*;

// 백준 1439 뒤집기

public class NO1439 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String s = scan.next();

        int count1 = 1;
        int count2 = 0;

        char check = s.charAt(0);
        int flag = 0;

        for(int i = 1; i < s.length(); i++)
        {
            char check2 = s.charAt(i);
            if(check != check2)
            {
                check = check2;
                if(flag == 0)
                {
                    flag = 1;
                    count2 += 1;
                }
                else if(flag == 1)
                {
                    flag = 0;
                    count1 += 1;
                }
            }
        }

        int answer = Math.min(count1, count2);
        System.out.print(answer);



    }
}
