package programmers.level1;

import java.util.*;
import java.lang.*;
import java.io.*;

public class 나머지가1이되는수찾기 {

    public static void main(String[] args) {

        int n1 = 10;
        int n2 = 12;

        System.out.println(solution(n1));
        System.out.println(solution(n2));

    }

    public static int solution(int n) {
        int answer = 0;

        int target = n - 1;

        if(n == 2) return answer = 1;

        for(int i = 2; i < n; i++)
        {
            if(target % i == 0)
            {
                answer = i;
                break;
            }
        }

        return answer;
    }



}

