package programmers.level1;

import java.util.*;
import java.lang.*;
import java.io.*;

public class 가운데글자가져오기 {

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "qwer";

        System.out.println(solution(s1));
        System.out.println(solution(s2));

    }

    public static String solution(String s) {
        String answer = "";

        int n = s.length();

        if(n%2==1)
            answer += s.charAt(n/2);
        else
            answer += s.substring(n/2-1, n/2+1);


        return answer;
    }

}
