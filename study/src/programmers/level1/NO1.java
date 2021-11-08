package programmers.level1;

import java.util.*;
import java.lang.*;
import java.io.*;

// 프로그래머스 Lv1. 로또의 최고 순위와 최저 순위

public class NO1 {
    public static void main(String[] args) {
        NO1 thisClass = new NO1();
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        System.out.println(thisClass.solution(lottos, win_nums));
    }

    // 이중 배열로 탐색

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        int[] rank = {6,6,5,4,3,2,1};

        int zero = 0;
        int match = 0;

        for(int i : lottos)
        {
            if(i == 0)
            {
                zero += 1;
            }
            else
            {
                for(int j : win_nums)
                {
                    if(i == j)
                    {
                        match += 1;
                    }
                }
            }
        }

        answer[0] = rank[match + zero];
        answer[1] = rank[match];
        return answer;
    }
}
