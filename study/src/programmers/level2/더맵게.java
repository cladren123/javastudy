package programmers.level2;

import java.util.*;


public class 더맵게 {

    public static void main(String[] args) {
        int[] scovile = {1,2,3,9,10,12};
        int K = 7;

        System.out.println(solution(scovile, K));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> heapq = new PriorityQueue<Integer>();

        int n = scoville.length;

        for(int i : scoville)
            heapq.add(i);

        // 가장 작은게 K 이상일 때
        // 스코빌 지수를 k이상으로 만들 수 없을 때

        int one = heapq.poll();
        int heapn = heapq.size();

        // 조건을 잘 정하는 것이 매우 중요하다.
        while(one < K && heapn != 0)
        {
            int two = heapq.poll();

            int sco = one + two * 2;
            heapq.add(sco);

            answer += 1;

            one = heapq.poll();
            heapn = heapq.size();
        }

        if(heapn == 0 && one < K) answer = -1;


        return answer;
    }
}
