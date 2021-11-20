package programmers.level1;

import java.util.*;
import java.lang.*;
import java.io.*;

public class 예산 {

    public static void main(String[] args) {

        int[] d1 = {1,3,2,5,4};
        int budget1 = 9;

        int[] d2 = {2,2,3,3};
        int budget2 = 10;

        System.out.println(solution(d1, budget1));
        System.out.println(solution(d2, budget2));

    }

    public static int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);

        for(int money : d)
        {
            budget -= money;
            if(budget < 0 ) break;
            else answer += 1;
        }

        return answer;
    }

}
