package programmers.level1;

import java.util.*;
import java.lang.*;
import java.io.*;

public class 두정수사이의합 {

    public static void main(String[] args) {
        int a1 = 3;
        int b1 = 5;

        int a2 = 3;
        int b2 = 3;

        int a3 = 5;
        int b3 = 3;

        System.out.println(solution(a1,b1));
        System.out.println(solution(a2,b2));
        System.out.println(solution(a3,b3));

    }

    public static long solution(int a, int b) {
        long answer = 0;

        int maxone = Math.max(a,b);
        int minone = Math.min(a,b);

        for(int i = minone; i <= maxone; i++) answer += i;

        return answer;
    }



}
