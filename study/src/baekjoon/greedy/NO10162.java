package baekjoon.greedy;

import java.util.*;
import java.lang.*;
import java.io.*;

public class NO10162 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        // 10, 60, 300

        int[] answer = new int[3];
        Arrays.fill(answer, 0);

        int a1 = t/300;
        answer[0] = a1;

        t = t - a1*300;

        int a2 = t/60;
        answer[1] = a2;

        t = t - a2*60;

        int a3 = t/10;
        answer[2] = a3;

        t = t - a3*10;

        if(t == 0)
        {
            for(int i = 0; i < 3; i++)
            {
                System.out.print(answer[i] + " ");
            }
        }
        else
        {
            System.out.print(-1);
        }





    }
}
