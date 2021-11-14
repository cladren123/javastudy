package programmers.level1;

import java.util.*;
import java.lang.*;
import java.io.*;

public class 내적 {
    public static void main(String[] args) {

        int[] a1 = {1,2,3,4};
        int[] b1 = {-3,-1,0,2};

        int[] a2 = {-1,0,1};
        int[] b2 = {1,0,-1};

        System.out.println(solution(a1,b1));
        System.out.println(solution(a2,b2));


    }

    public static int solution(int[] a, int[] b) {
        int answer = 0;

        int n = a.length;

        for(int i = 0; i < n; i++)
        {
            answer += (a[i] * b[i]);
        }


        return answer;
    }
}
