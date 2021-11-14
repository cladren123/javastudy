package programmers.level1;

import java.util.*;
import java.lang.*;
import java.io.*;

public class 크레인인형뽑기게임 {

    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println(solution(board, moves));


    }


    public static  int solution(int[][] board, int[] moves) {
        int answer = 0;

        ArrayList<Integer> array = new ArrayList<Integer>();

        int n = board.length;

        for(int crak : moves)
        {
            for(int i = 0; i < n; i++)
            {
                if(board[i][crak-1] != 0 )
                {
                    if(array.size() > 0 && array.get(array.size()-1) == board[i][crak-1])
                    {
                        array.remove(array.size()-1);
                        answer += 2;
                        board[i][crak-1] = 0;
                    }
                    else
                    {
                        array.add(board[i][crak-1]);
                        board[i][crak-1] = 0;
                    }
                    break;
                }
            }

        }

        System.out.println(array);



        return answer;
    }
}
