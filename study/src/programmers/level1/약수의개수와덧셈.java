package programmers.level1;

import java.util.*;
import java.lang.*;
import java.io.*;


public class 약수의개수와덧셈 {

    public static void main(String[] args) {
        int left1 = 13;
        int right1 = 17;

        int left2 = 24;
        int right2 = 27;

        System.out.println(solution(left1, right1));
        System.out.println(solution(left2, right2));

    }

    public static int solution(int left, int right) {
        int answer = 0;

        // 제곱근이 있으면 약수가 홀수개
        for(int i = left; i <= right; i++)
        {
            if(i % Math.sqrt(i) == 0 ) answer -= i;
            else answer += i;
        }

        return answer;
    }

}
