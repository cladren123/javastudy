package programmers.level2.twopage;

import java.util.*;

public class 카펫 {

    public static void main(String[] args) {
        int brown1 = 10;
        int yellow1 = 2;

        int brown2 = 8;
        int yellow2 = 1;

        int brown3 = 24;
        int yellow3 = 24;

        System.out.println(Arrays.toString(solution(brown1, yellow1)));
        System.out.println(Arrays.toString(solution(brown2, yellow2)));
        System.out.println(Arrays.toString(solution(brown3, yellow3)));

    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = {};
        answer = new int[2];

        for(int i = 1; i <= yellow; i++)
        {
            if(yellow % i == 0)
            {
                int j = yellow / i;

                int x = j + 2;
                int y = i + 2;

                int all = x * y;

                if(all == brown + yellow)
                {
                    answer[0] = x;
                    answer[1] = y;
                    break;
                }
            }
        }
        return answer;
    }
}
