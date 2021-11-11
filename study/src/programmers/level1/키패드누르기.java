package programmers.level1;

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.IntStream;

public class 키패드누르기 {

    public static void main(String[] args) {

        int[] numbers1 = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        int[] numbers2 = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        int[] numbers3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        String hand1 = "right";
        String hand2 = "left";
        String hand3 = "right";

        System.out.println(solution(numbers1, hand1));
        System.out.println(solution(numbers2, hand2));
        System.out.println(solution(numbers3, hand3));


    }

    public static String solution(int[] numbers, String hand) {
        String answer = "";

        int[][] board = new int[4][3];
        int count = 1;
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                board[i][j] = count;
                count++;
            }
        }
        board[3][0] = 10;
        board[3][1] = 0;
        board[3][2] = 11;



        int[] lnum = {1,4,7};
        int[] rnum = {3,6,9};

        // 손의 위치
        int[] lhand = {3,0};
        int[] rhand = {3,2};



        for(int num : numbers)
        {
            // 왼쪽 숫자일 때
            if(IntStream.of(lnum).anyMatch(i -> i == num))
            {

                answer += "L";
                for(int i1 = 0; i1 < 4; i1++)
                {
                    for(int j1 = 0; j1 < 3; j1++)
                    {
                        if(board[i1][j1] == num)
                        {
                            lhand[0] = i1;
                            lhand[1] = j1;
                        }
                    }
                }
            }

            // 오른쪽 숫자일 때
            else if(IntStream.of(rnum).anyMatch(i -> i == num))
            {
                answer += "R";
                for(int i2 = 0; i2 < 4; i2++)
                {
                    for(int j2 = 0; j2 < 3; j2++)
                    {
                        if(board[i2][j2] == num)
                        {
                            rhand[0] = i2;
                            rhand[1] = j2;

                        }
                    }
                }
            }

            else
            {

                for(int i3 = 0; i3 < 4; i3++)
                {
                    for(int j3 = 0; j3 < 3; j3++)
                    {
                        if(board[i3][j3] == num)
                        {

                            int lcheck = Math.abs(i3 - lhand[0]) + Math.abs(j3 - lhand[1]);
                            int rcheck = Math.abs(i3 - rhand[0]) + Math.abs(j3 - rhand[1]);


                            if(lcheck < rcheck)
                            {
                                answer += "L";
                                lhand[0] = i3;
                                lhand[1] = j3;
                            }

                            else if(lcheck > rcheck)
                            {
                                answer += "R";
                                rhand[0] = i3;
                                rhand[1] = j3;

                            }

                            else if(lcheck == rcheck)
                            {
                                if(hand == "left")
                                {
                                    answer += "L";
                                    lhand[0] = i3;
                                    lhand[1] = j3;
                                }

                                if(hand == "right")
                                {
                                    answer += "R";
                                    rhand[0] = i3;
                                    rhand[1] = j3;

                                }
                            }
                        }
                    }
                }

            }

        }




        return answer;
    }


}
