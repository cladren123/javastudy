package programmers.level3.page3;

import java.util.*;

public class 거스름돈 {

    public static void main(String[] args) {

        int n = 5;
        int[] money = {1,2,5};

        System.out.println(solution(n,money));

    }

    public static int solution(int n, int[] money) {
        int answer = 0;

        int moneyn = money.length;

        int[][] board = new int[moneyn+1][n+1];

        Arrays.sort(money);



        for(int i = 1; i < moneyn+1; i++)
        {
            int num = money[i-1];
            board[i][num] += 1;

            for(int j = 1; j < n+1; j++)
            {
                board[i][j] += board[i-1][j];

                if(j >= num)
                    board[i][j] += board[i][j-num];
            }


        }

        // for(int i = 0; i < moneyn+1; i++)
        //     System.out.println(Arrays.toString(board[i]));


        answer = board[moneyn][n];


        return answer;
    }


}
