package programmers.level1;

import java.util.*;

public class 정수내림차순으로배치하기 {

    public static void main(String[] args) {

        int n1 = 118372;

        System.out.println(solution(n1));

    }

    public static long solution(long n) {
        long answer = 0;

        String s = String.valueOf(n);
        int slen = s.length();

        Integer[] array = new Integer[slen];

        for(int i = 0; i < slen; i++)
        {
            array[i] = (int)(s.charAt(i) - '0');
        }

        Arrays.sort(array, Collections.reverseOrder());

        String one = "";

        for(int i = 0; i < slen; i++)
            one += String.valueOf(array[i]);

        answer = Long.parseLong(one);

        return answer;
    }
}
