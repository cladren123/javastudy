package programmers.level1;

import java.util.*;

public class 행렬의덧셈 {

    public static void main(String[] args) {
        int[][] arr11 = {{1,2}, {2,3}};
        int[][] arr21 = {{3,4}, {5,6}};

        int[][] arr12 = {{1}, {2}};
        int[][] arr22 = {{3}, {4}};

        System.out.println(Arrays.toString(solution(arr11, arr21)));
        System.out.println(Arrays.toString(solution(arr12, arr22)));
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = {};

        int n = arr1.length;
        int m = arr1[0].length;

        answer = new int[n][m];

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        return answer;
    }
}
