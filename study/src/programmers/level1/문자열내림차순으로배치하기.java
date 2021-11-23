package programmers.level1;

import java.util.*;
import java.lang.*;
import java.io.*;

public class 문자열내림차순으로배치하기 {

    public static void main(String[] args) {

        String s = "Zbcdefg";

        System.out.println(solution(s));

    }

    public static String solution(String s) {
        String answer = "";

        // 문자는 큰 것부터 작은 순으로 정렬
        // 대문자는 소문자보다 작은 것으로 간주

        int n = s.length();

        ArrayList<Character> store = new ArrayList<Character>();

        for(int i = 0; i < n; i++)
        {
            store.add(s.charAt(i));
        }

        Collections.sort(store, Collections.reverseOrder());

        for(int i = 0; i < n; i++)
        {
            answer += store.get(i);
        }


        return answer;
    }

}
