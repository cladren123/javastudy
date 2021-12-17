package programmers.level3.page1;

import java.util.*;

public class 입국심사 {

    public static void main(String[] args) {

        int n = 6;
        int[] times = {7,10};

        System.out.println(solution(n,times));

    }

    public static long solution(int n, int[] times) {

        // 최대값으로 설정
        long answer = Long.MAX_VALUE;

        // 이분탐색을 위한 정렬
        Arrays.sort(times);

        // mid : 심사를 받는데 주어진 시간
        // sum : 주어진 시간 동안 심사를 받을 수 있는 사람의 수
        long start, mid, end;

        start = 0;
        end = Long.MAX_VALUE;
        long sum;


        while(start <= end)
        {
            mid = (start + end) / 2;

            sum = 0;

            for(int i = 0; i < times.length; i++)
            {
                sum += mid / times[i];

                if(sum >= n)
                    break;
            }

            if(n > sum)
            {
                start = mid + 1;
            }
            else
            {
                end = mid - 1;
                answer = Math.min(answer, mid);
            }

        }




        return answer;
    }
}
