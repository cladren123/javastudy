package programmers.level2.threepage;

import java.util.*;
import java.lang.*;

public class 땅따먹기 {

    public static void main(String[] args) {

        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};

        System.out.println(solution(land));

    }

    static int solution(int[][] land) {
        int answer = 0;

        int n = land.length;

        for(int i = 1; i < n; i++)
        {
            land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
            land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
            land[i][2] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][3]));
            land[i][3] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][2]));
        }

        answer = Math.max(land[n-1][0], Math.max(land[n-1][1], Math.max(land[n-1][2], land[n-1][3])) );


        return answer;
    }

}
