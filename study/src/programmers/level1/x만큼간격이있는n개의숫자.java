package programmers.level1;

import java.util.*;

public class x만큼간격이있는n개의숫자 {

    public static void main(String[] args) {

        int x1 = 2;
        int n1 = 5;

        int x2 = 4;
        int n2 = 3;

        int x3 = -4;
        int n3 = 2;

        System.out.println(Arrays.toString(solution(x1,n1)));
        System.out.println(Arrays.toString(solution(x2,n2)));
        System.out.println(Arrays.toString(solution(x3,n3)));

    }

    public static long[] solution(int x, int n) {
        long[] answer = {};
        answer = new long[n];

        for(int i = 0; i < n; i++)
        {
            answer[i] = (long)x * (i+1);
        }


        return answer;
    }
}
