package programmers.level1;

import java.util.*;
import java.lang.*;

public class 실패율 {
    public static void main(String[] args) {
        int n1 = 5;
        int[] stages1 = {2,1,2,6,2,4,3,3};

        int n2 = 4;
        int[] stages2 = {4,4,4,4,4};

        System.out.println(Arrays.toString(solution(n1, stages1)));
        System.out.println(Arrays.toString(solution(n2, stages2)));

    }

    // 내림차순 : 큰 숫자에서 작은 숫자

    public static int[] solution(int N, int[] stages) {
        int[] answer = {};

        // 도달했던 사람들
        int[] reachplayer = new int[N+1];
        Arrays.fill(reachplayer, 0);

        // 현재 멈춰있는 사람들
        int[] nowplayer = new int[N+1];
        Arrays.fill(nowplayer, 0);

        for(int i : stages)
        {
            int newn = Math.min(i,N);
            for(int j = 1; j <= newn; j++) reachplayer[j] += 1;
            if(i < N+1) nowplayer[i] += 1;
        }

        // 실패율
        int[] fail = new int[N];
         












        return answer;
    }

}
