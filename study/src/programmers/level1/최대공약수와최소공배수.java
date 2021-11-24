package programmers.level1;

import java.util.*;

public class 최대공약수와최소공배수 {

    public static void main(String[] args) {

        int n1 = 3;
        int m1 = 12;

        int n2 = 2;
        int m2 = 5;

        System.out.println(Arrays.toString(solution(n1,m1)));
        System.out.println(Arrays.toString(solution(n2,m2)));
    }

    public static int[] solution(int n, int m) {
        int[] answer = {};

        int maxnum = Math.max(n,m);
        int minnum = Math.min(n,m);

        int gongyak = 0;

        for(int i = 1; i <= minnum; i++)
        {
            if(maxnum % i == 0 && minnum % i == 0) gongyak = i;
        }

        int gongbae = gongyak * (maxnum / gongyak) * (minnum / gongyak);

        answer = new int[2];

        answer[0] = gongyak;
        answer[1] = gongbae;

        return answer;

    }


}
