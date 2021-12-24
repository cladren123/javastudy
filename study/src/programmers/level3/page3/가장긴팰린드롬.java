package programmers.level3.page3;

import java.util.*;


public class 가장긴팰린드롬 {

    public static void main(String[] args) {

        String s1 = "abcdcba";
        String s2 = "abacde";

        System.out.println(solution(s1));
        System.out.println(solution(s2));

    }

    public static int solution(String s)
    {
        int answer = 0;
        int n = s.length();


        // 문자 자릿수
        for(int i = n; i >= 1; i--)
        {
            // 문자 시작점
            for(int j = 0; j + i <= n; j++)
            {
                int flag = 1;

                for(int k = 0; k < (int)(i/2); k++)
                {
                    if(s.charAt(k+j) != s.charAt(j+i-k-1))
                    {
                        flag = 0;
                        break;
                    }
                }
                if(flag == 1)
                    return i;
            }
        }


        return answer;
    }

}
