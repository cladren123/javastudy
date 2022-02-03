package programmers.kakoblind2022;

import java.util.*;

public class 양궁대회2트 {

    public static void main(String[] args) {

        int n = 5;
        int[] info = {2,1,1,1,0,0,0,0,0,0,0};

        System.out.println(Arrays.toString(solution(n, info)));

    }


    static int[] answer = {-1};

    static int[] lion;
    static int[] appeach;
    static int answerscore;

    public static int[] solution(int n, int[] info) {

        lion = new int[11];
        appeach = info;
        answerscore = -1000;

        dfs(0, n);


        return answer;
    }

    public static void dfs(int stage, int n)
    {
        // 종단조건 : 화살을 다 쐈을 때
        if(stage == n)
        {
            System.out.println(Arrays.toString(lion));
//            check();
            return;
        }

        for(int i = 0; i < 11 && lion[i] <= appeach[i] ; i++)
        {
            lion[i]++;
            dfs(stage + 1, n);
            lion[i]--;
        }
    }


    public static void check()
    {
        int lionPoint = 0;
        int appeachPoint = 0;

        for(int i = 0; i < 11; i++)
        {
            if(appeach[i] != 0 || lion[i] != 0)
            {
                if(lion[i] > appeach[i])
                {
                    lionPoint += 10 - i;
                }
                else if(lion[i] <= appeach[i])
                {
                    appeachPoint += 10 - i;
                }
            }
        }


        int score = lionPoint - appeachPoint;

        if(score > 0 && score >= answerscore)
        {
            answer = lion.clone();
            answerscore = score;
        }


    }


}
