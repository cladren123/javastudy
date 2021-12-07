package programmers.level2.twopage;

import java.util.*;

public class 주식가격 {

    public static void main(String[] args) {
        int[] prices = {1,2,3,2,3};

        System.out.println(Arrays.toString(solution(prices)));
    }

    public static int[] solution(int[] prices) {
        int[] answer = {};

        int n = prices.length;

        answer = new int[n];

        for(int i = 0; i < n-1; i++)
        {
            for(int j = i+1; j < n; j++)
            {
                answer[i] += 1;
                if(prices[i] > prices[j])
                    break;
            }
        }

        return answer;
    }


}
