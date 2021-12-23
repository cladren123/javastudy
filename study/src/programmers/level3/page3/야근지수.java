package programmers.level3.page3;

import java.util.*;
import java.lang.*;

public class 야근지수 {

    public static void main(String[] args) {

        int[] works1 = {4,3,3};
        int n1 = 4;

        int[] works2 = {2,1,2};
        int n2 = 1;

        int[] works3 = {1,1};
        int n3 = 3;

        System.out.println(solution(n1, works1));
        System.out.println(solution(n2, works2));
        System.out.println(solution(n3, works3));

    }

    public static long solution(int n, int[] works) {
        long answer = 0;

        int worksn = works.length;

        // 내림차순으로 우선순위큐 선언
        PriorityQueue<Integer> prique = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < worksn; i++)
        {
            prique.add(works[i]);
        }

        for(int i = 0; i < n; i++)
        {
            int num = prique.poll();

            if(num == 0)
                return 0;

            num -= 1;
            prique.add(num);
        }

        for(int i = 0; i < worksn; i++)
        {
            int one = prique.poll();
            answer += one * one;
        }


        return answer;
    }

}
