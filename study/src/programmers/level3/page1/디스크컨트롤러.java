package programmers.level3.page1;

import java.util.*;
import java.lang.*;

public class 디스크컨트롤러 {

    public static void main(String[] args) {

        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};

        System.out.println(solution(jobs));

    }

    public static int solution(int[][] jobs) {
        int answer = 0;

        int end = 0;
        int jobindex = 0;
        int count = 0;

        // 요청시간 오름차순
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);



        PriorityQueue<int[]> pq = new PriorityQueue<>( (o1, o2) -> o1[1] - o2[1]);



        while(count < jobs.length)
        {

            while(jobindex < jobs.length && jobs[jobindex][0] <= end)
            {
                pq.add(jobs[jobindex++]);
            }


            if(pq.isEmpty()) {
                end = jobs[jobindex][0];
            }
            else
            {
                int[] temp = pq.poll();
                answer += temp[1] + end - temp[0];
                end += temp[1];
                count++;
            }
        }

        answer = (int) Math.floor(answer / jobs.length);

        return answer;
    }

}
