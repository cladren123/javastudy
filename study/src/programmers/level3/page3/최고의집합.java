package programmers.level3.page3;

import java.util.*;

public class 최고의집합 {

    public static void main(String[] args) {

        int n1 = 2;
        int s1 = 9;

        int n2 = 2;
        int s2 = 1;

        int n3 = 2;
        int s3 = 8;

        System.out.println(Arrays.toString(solution(n1, s1)));
        System.out.println(Arrays.toString(solution(n2, s2)));
        System.out.println(Arrays.toString(solution(n3, s3)));

    }

    public static int[] solution(int n, int s) {
        int[] answer = {};

        answer = new int[n];

        int num = (int)(s/n);



        if(s < n)
        {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }

        Arrays.fill(answer, num);


        int diff = s - num * n; // 나머지
        int index = n-1;

        while(diff != 0)
        {
            answer[index] += 1;

            index -= 1;
            if(index < 0) index = n-1;

            diff -= 1;
        }

        return answer;
    }


}
