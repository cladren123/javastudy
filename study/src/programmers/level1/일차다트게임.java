package programmers.level1;

import java.util.*;
import java.lang.*;
import java.io.*;

public class 일차다트게임 {

    public static void main(String[] args) {

        String dartResult1 = "1S2D*3T";
        String dartResult2 = "1D2S#10S";
        String dartResult3 = "1D2S0T";
        String dartResult4 = "1S*2T*3S";
        String dartResult5 = "1D#2S*3S";
        String dartResult6 = "1T2D3D#";
        String dartResult7 = "1D2S3T*";

        System.out.println(solution(dartResult1));
        System.out.println(solution(dartResult2));
        System.out.println(solution(dartResult3));
        System.out.println(solution(dartResult4));
        System.out.println(solution(dartResult5));
        System.out.println(solution(dartResult6));
        System.out.println(solution(dartResult7));

    }

    public static int solution(String dartResult) {
        int answer = 0;

        int[] scores = new int[3];

        String sb = "";

        int n = dartResult.length();
        int count = 0;

        for(int i = 0; i < n; i++)
        {
            char one = dartResult.charAt(i);
            if(Character.isDigit(one))
            {
                sb += one;
            }
            else
            {
                if(one == 'S')
                {
                    Integer score = Integer.parseInt(sb);
                    scores[count] = score;
                    count += 1;
                }
                else if(one == 'D')
                {
                    Integer score = Integer.parseInt(sb);
                    scores[count] = score * score;
                    count += 1;
                }
                else if(one == 'T')
                {
                    Integer score = Integer.parseInt(sb);
                    scores[count] = score * score * score;
                    count += 1;
                }
                
                // 초기화
                sb = "";

                if(one == '*')
                {
                    if(count == 1) scores[count-1] = scores[count-1] * 2;
                    else if(count > 1)
                    {
                        scores[count-2] = scores[count-2] * 2;
                        scores[count-1] = scores[count-1] * 2;
                    }
                }
                else if(one == '#') scores[count-1] = -scores[count-1];
            }
        }

        for(int i = 0; i < 3; i++) answer += scores[i];

        return answer;
    }

}
