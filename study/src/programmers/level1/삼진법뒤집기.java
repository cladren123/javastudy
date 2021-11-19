package programmers.level1;

import java.util.*;
import java.lang.*;
import java.io.*;

public class 삼진법뒤집기 {

    public static void main(String[] args) {

        int n1 = 45;
        int n2 = 125;

        System.out.println(solution(n1));
        System.out.println(solution(n2));

    }

    public static int solution(int n) {
        int answer = 0;
        ArrayList<Integer> three = new ArrayList<>();

        // 종단조건을 설정하는 것이 주요하다.
        // 모든 경우에서 종료되는 경우를 찾아야 한다.
        while(true)
        {
            if(n<3)
            {
                three.add(n);
                break;
            }
            int inja = n % 3;
            three.add(inja);
            n = (int)(n / 3);
        }



        for(int i = 0; i < three.size(); i++)
        {
            answer += three.get(i) * Math.pow(3,three.size() -1 - i);
        }

        return answer;
    }

}
