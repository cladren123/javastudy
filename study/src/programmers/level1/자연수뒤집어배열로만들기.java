package programmers.level1;

import java.util.*;

public class 자연수뒤집어배열로만들기 {

    public static void main(String[] args) {

        int n1 = 12345;

        System.out.println(Arrays.toString(solution(n1)));

    }

    public static int[] solution(long n) {
        int[] answer = {};

        String s = String.valueOf(n);

        int slen = s.length();

        answer = new int[slen];
        int index = slen -1;

        for(int i = 0; i < slen; i++)
        {
            answer[i] = (int)(s.charAt(index) - '0');
            index -= 1;
        }

        return answer;
    }
}
