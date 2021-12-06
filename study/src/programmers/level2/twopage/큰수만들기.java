package programmers.level2.twopage;

import java.util.*;

public class 큰수만들기 {

    public static void main(String[] args) {

        String number1 = "1924";
        int k1 = 2;

        String number2 = "1231234";
        int k2 = 3;

        String number3 = "4177252841";
        int k3 = 4;

        System.out.println(solution(number1, k1));
        System.out.println(solution(number2, k2));
        System.out.println(solution(number3, k3));

    }

    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();

        char[] sortnumber = number.toCharArray();

        int n = number.length();

        int maxnum = 0;
        int index = 0;


        // 처음부터 k개를 뺀 수 만큼 탐색
        for(int i = 0; i < n - k; i++)
        {
            maxnum = 0;

            // 앞 쪽의 숫자를 찾고
            for(int j = index; j <= i+k; j++)
            {
                if(maxnum < number.charAt(j) - '0')
                {
                    maxnum = number.charAt(j) - '0';
                    index = j+1;
                }
            }
            answer.append(maxnum);
        }

        return answer.toString();
    }

}
