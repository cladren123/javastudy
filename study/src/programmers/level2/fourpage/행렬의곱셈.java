package programmers.level2.fourpage;

import java.util.*;

public class 행렬의곱셈 {

    public static void main(String[] args) {

        int[][] arr11 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr21 = {{3, 3}, {3, 3}};

        int[][] arr12 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
        int[][] arr22 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};

        System.out.println(Arrays.toString(solution(arr11 ,arr21)));
        System.out.println(Arrays.toString(solution(arr12 ,arr22)));

    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = {};


        int n1 = arr1.length;
        int m1 = arr1[0].length;

        int n2 = arr2.length;
        int m2 = arr2[0].length;

        // 첫번째 행렬에 행, 두번째 행렬에 렬

        answer = new int[n1][m2];

        for(int i = 0; i < n1; i++)
        {
            for(int j = 0; j < m2; j++)
            {
                int result1 = 0;

                for(int k = 0; k < m1; k++)
                {
                    result1 += arr1[i][k] * arr2[k][j];
                }

                answer[i][j] = result1;


            }
        }


        return answer;
    }

}
