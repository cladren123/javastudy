package programmers.level2.page3;

import java.util.*;

public class n2배열자르기 {

    public static void main(String[] args) {
        int n1 =3;
        long left1 = 2;
        long right1 = 5;

        int n2 =4;
        long left2 = 7;
        long right2 = 14;

        System.out.println(solution(n1,left1,right1));
        System.out.println(solution(n2,left2,right2));

    }

    // solution의 형식을 변경해도 괜찮다.
    public static List<Long> solution(int n, long left, long right) {
        int[] answer = {};

        List<Long> list = new ArrayList<>();

        for(long i = left; i <= right; i++)
            list.add(Math.max(i/n, i%n) + 1);



        return list;
    }

}
