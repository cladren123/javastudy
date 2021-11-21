package programmers.level1;

import java.util.*;
import java.lang.*;
import java.io.*;


public class 최소직사각형 {

    public static void main(String[] args) {

        int[][] sizes1 = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        int[][] sizes2 = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
        int[][] sizes3 = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};

        System.out.println(solution(sizes1));
        System.out.println(solution(sizes2));
        System.out.println(solution(sizes3));
    }

    public static int solution(int[][] sizes) {
        int answer = 0;

        int n = sizes.length;

        int[][] newsizes = new int[n][2];

        int garo = 0;
        int sero = 0;

        for(int i = 0; i < n; i++)
        {
            int maxone = Math.max(sizes[i][0], sizes[i][1]);
            int minone = Math.min(sizes[i][0], sizes[i][1]);

            garo = Math.max(garo, maxone);
            sero = Math.max(sero, minone);

        }

        answer = garo * sero;

        return answer;
    }
}
