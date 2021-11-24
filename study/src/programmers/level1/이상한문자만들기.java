package programmers.level1;

import java.util.*;
import java.lang.*;
import java.io.*;

public class 이상한문자만들기 {

    public static void main(String[] args) {

        String s1 = "try hello world";
        String s2 = " Hello";

        System.out.println(solution(s1));
        System.out.println(solution(s2));

    }

    /*
    StringTokenizer를 쓰면 안되는 이유
    " " 이 얼마나 많을지 모르기 때문이다.  ㅡㅜ
     */

    public static String solution(String s) {
        String answer = "";

        int n = s.length();
        int index = 0;

        for(int i = 0; i < n; i++)
        {
            char cha = s.charAt(i);

            if(Character.isLetter(cha))
            {
                if(index % 2 == 0) cha = Character.toUpperCase(cha);
                else cha = Character.toLowerCase(cha);
                index += 1;
            }
            else index = 0;

            answer += cha;

        }

        return answer;
    }
}
