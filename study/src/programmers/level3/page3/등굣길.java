package programmers.level3.page3;

import java.util.*;

public class 등굣길 {

    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2,2}};

        System.out.println(solution(m,n,puddles));
    }

    public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;


        int[][] board = new int[n+1][m+1];

        int num = 1000000007;

        // 웅덩이 표시
        for(int i = 0; i < puddles.length; i++)
        {
            int x = puddles[i][0];
            int y = puddles[i][1];

            board[y][x] = -1;
        }


        // for(int i = 0; i < n+1; i++)
        //     System.out.println(Arrays.toString(board[i]));

        for(int i = 1; i < n+1; i++)
        {
            for(int j = 1; j < m+1; j++)
            {
                // 물웅덩이는 0으로 표시
                if(board[i][j] == -1) board[i][j] = 0;
                    // (1,1) 위치는 무조건 1이 들어온다.
                else if(i == 1 && j == 1) board[i][j] = 1;
                    // dp, 왼쪽과 위쪽에서 들어오는 경우의 수를 구한다.
                else
                    board[i][j] = board[i-1][j]%num + board[i][j-1]%num;
            }
        }

        // System.out.println();
        // for(int i = 0; i < n+1; i++)
        //     System.out.println(Arrays.toString(board[i]));

        answer = board[n][m]%num;


        return answer;
    }


}
