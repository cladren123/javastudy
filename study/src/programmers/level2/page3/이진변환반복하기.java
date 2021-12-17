package programmers.level2.page3;

import java.util.*;

public class 이진변환반복하기 {

    public static void main(String[] args) {
        String s1 = "110010101001";
        String s2 = "01110";
        String s3 = "1111111";

        System.out.println(Arrays.toString(solution(s1)));
        System.out.println(Arrays.toString(solution(s2)));
        System.out.println(Arrays.toString(solution(s3)));
    }

    public static int[] solution(String s) {
        int[] answer = {};
        answer = new int[2];

        int count = 0;
        int zero = 0;

        while(s.length() != 1)
        {
            count += 1;

            int n = s.length();
            s = s.replaceAll("[0]", "");
            int m = s.length();

            zero = zero + (n - m);

            s = Integer.toBinaryString(m);

        }

        answer[0] = count;
        answer[1] = zero;

        return answer;
    }

}
