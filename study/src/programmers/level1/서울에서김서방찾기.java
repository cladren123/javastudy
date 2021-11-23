package programmers.level1;

import java.util.*;

public class 서울에서김서방찾기 {

    public static void main(String[] args) {

        String[] seoul = {"Jane", "Kim"};

        System.out.println(solution(seoul));

    }

    public static String solution(String[] seoul) {
        String answer = "김서방은 ";

        int n = seoul.length;

        for(int i = 0; i < n; i++)
        {
            if(seoul[i].equals("Kim")) answer += String.valueOf(i);
        }

        answer += "에 있다";

        return answer;
    }

}
