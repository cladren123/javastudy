package programmers.level1;

import java.util.*;
import java.lang.*;
import java.io.*;

public class 신규아이디추천 {
    public static void main(String[] args) {

        String new_id1 = "...!@BaT#*..y.abcdefghijklm";
        System.out.println(solution(new_id1));

        String new_id2 = "z-+.^.";
        System.out.println(solution(new_id2));

        String new_id3 = "=.=";
        System.out.println(solution(new_id3));

        String new_id4 = "123_.def";
        System.out.println(solution(new_id4));

        String new_id5 = "abcdefghijklmn.p";
        System.out.println(solution(new_id5));




    }

    public static String solution(String new_id) {
        String answer = "";

        // 대문자 변환 : toUpperCase();
        // 1단계 : 대문자 소문자로 치환
        String new_id1 = new_id.toLowerCase();
//        System.out.println(new_id1);

        // 2단계 : 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
        String new_id2 = "";
        for(int i = 0; i < new_id1.length(); i++)
        {
            char one = new_id1.charAt(i);

            if(one >= 'a' && one <= 'z')
            {
                new_id2 += String.valueOf(one);
            }
            else if(one >= '0' && one <= '9')
            {
                new_id2 += String.valueOf(one);
            }
            else if(one == '-' || one == '_' || one == '.')
            {
                new_id2 += String.valueOf(one);
            }
        }

        // System.out.println(new_id2);

        // 3단계 : 마침표가 2번 이상 연속된 부분을 하나의 마침표로 치환한다.
        String new_id3 = new_id2.replace("..", ".");

        while(new_id3.contains(".."))
        {
            new_id3 = new_id3.replace("..", ".");
        }

        // System.out.println(new_id3);


        // 4단계 : new_id에서 마침표가 처음이나 끝에 위치하면 제거한다.
        String new_id4 = new_id3;
        if(new_id4.length() > 0)
        {
            if(new_id4.charAt(0) == '.')
            {
                new_id4 = new_id4.substring(1,new_id4.length());
            }
        }
        if(new_id4.length() > 0)
        {
            if(new_id4.charAt(new_id4.length()-1) == '.')
            {
                new_id4 = new_id4.substring(0, new_id4.length()-1);
            }
        }

        // System.out.println(new_id4);

        // 5단계 : 빈 문자열이면 a를 대입한다.
        String new_id5 = new_id4;
        if(new_id5.length() == 0)
        {
            new_id5 += 'a';
        }

        // System.out.println(new_id5);

        // 6단계 : 길이가 16이상이면, 첫 15개의 문자를 제외한 나머지 문자들을 제거한다.
        // 만약 제거 후 마침표가 끝에 위치하면 끝에 위치한 마침표를 제거한다.

        String new_id6 = new_id5;
        if(new_id6.length() >= 16)
        {
            new_id6 = new_id6.substring(0,15);
        }

        if(new_id6.charAt(new_id6.length()-1) == '.')
        {
            new_id6 = new_id6.substring(0, new_id6.length()-1);
        }

        // System.out.println(new_id6);

        // 7단계 : 길이가 2자 이하면, 마지막 문자를 문자열의 길이가 3이 될 때까지 반복해서 뒤에 붙힌다.
        String new_id7 = new_id6;

        while(new_id7.length() <= 2)
        {
            char last = new_id7.charAt(new_id7.length()-1);
            new_id7 += last;
        }

        // System.out.println(new_id7);

        answer += new_id7;

        return answer;
    }
}
