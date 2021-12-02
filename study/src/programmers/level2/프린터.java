package programmers.level2;

import java.util.*;
import java.lang.*;
import java.io.*;

public class 프린터 {

    public static void main(String[] args) {

        int[] priorities1 = {2,1,3,2};
        int location1 = 2;

        int[] priorities2 = {1,1,9,1,1,1};
        int location2 = 0;

        System.out.println(solution(priorities1, location1));
        System.out.println(solution(priorities2, location2));

    }

    static class dot
    {
        int priority;
        int index;

        public dot(int priority, int index)
        {
            this.priority = priority;
            this.index = index;
        }

        // 출력문
        public String toString()
        {
            String one;
            one = String.valueOf(this.priority) + " " + String.valueOf(this.index);
            return one;
        }


    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        // 큐에 <우선순위, 인덱스>로 담는다.
        Queue<dot> store = new LinkedList<>();
        int n = priorities.length;
        for(int i = 0; i < n; i++)
        {
            store.add(new dot(priorities[i], i));
        }

        // 출력 순서를 담을 변수
        int count = 0;

        while(!store.isEmpty())
        {
            dot d = store.poll();

            // 자신보다 높은 우선순위가 있는지 파악
            int flag = 1;

            for(dot bigyo : store)
            {
                if(d.priority < bigyo.priority)
                {
                    store.add(d);
                    flag = 0;
                    break;
                }
            }

            // 자신이 우선순위가 제일 높은 경우
            if(flag == 1)
            {
                count += 1;
                // 해당 인덱스인 경우
                if(d.index == location)
                {
                    answer = count;
                }
            }
        }

        return answer;

    }



}
