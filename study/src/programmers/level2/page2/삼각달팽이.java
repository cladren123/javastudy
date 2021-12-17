package programmers.level2.page2;

import java.util.*;
import java.lang.*;

public class 삼각달팽이 {

    public static void main(String[] args) {

        int n1 = 4;
        int n2 = 5;
        int n3 = 6;

        System.out.println(Arrays.toString(solution(n1)));
        System.out.println(Arrays.toString(solution(n2)));
        System.out.println(Arrays.toString(solution(n3)));


    }

    public static int[] solution(int n) {
        int[] answer = {};

        int[][] board = new int[n][n];


        int target = 0;
        for(int i = 1; i <= n; i++)
            target += i;

        int y = 0;
        int x = 0;
        int index = 1;

        board[y][x] = index;

        while(index < target)
        {
            while(y + 1 < n && index < target && board[y+1][x] == 0)
            {
                board[++y][x] = ++index;
            }

            while(x + 1 < n && index < target && board[y][x+1] == 0)
            {
                board[y][++x] = ++index;
            }

            while(y - 1 > 0 && x - 1 > 0 && index < target && board[y-1][x-1] == 0)
            {
                board[--y][--x] = ++index;
            }


        }


        answer = new int[target];

        index = 0;

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(board[i][j] != 0)
                {
                    answer[index] = board[i][j];
                    index += 1;
                }
            }
        }

        return answer;
    }
}
