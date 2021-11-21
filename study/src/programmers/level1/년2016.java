package programmers.level1;

import java.util.*;
import java.lang.*;
import java.io.*;

public class 년2016 {
    public static void main(String[] args) {

        int a = 5;
        int b = 24;
        System.out.println(solution(a,b));

    }

    // a : 월, b = 일

    public static String solution(int a, int b) {
        String answer = "";

        String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        // 1월 1일 : 금요일
        //                 금  월 화  금 일 수 금 월 목 토 화 목

        int[] startmonth = {5, 1, 2, 5, 0, 4, 5, 1, 4, 6, 2, 4};

        int startnum = startmonth[a-1];

        int targetnum = (startnum + (b%7)-1)%7;

        answer = days[targetnum];

        return answer;
    }


}
