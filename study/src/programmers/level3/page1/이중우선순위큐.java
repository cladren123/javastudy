package programmers.level3.page1;

import java.util.*;

public class 이중우선순위큐 {

    public static void main(String[] args) {

        String[] operations = {"I 16","D 1"};

        System.out.println(Arrays.toString(solution(operations)));

    }



    public static int[] solution(String[] operations) {
        int[] answer = {};
        answer = new int[2];

        PriorityQueue<Integer> pqmin = new PriorityQueue<>();
        PriorityQueue<Integer> pqmax = new PriorityQueue<>(Collections.reverseOrder());

        for(String operation : operations)
        {
            String[] one = operation.split(" ");
            String word = one[0];
            int number = Integer.parseInt(one[1]);



            // 추가
            if(word.equals("I"))
            {
                pqmin.add(number);
                pqmax.add(number);
            }
            else if(word.equals("D"))
            {
                // 빈 큐에 데이터를 삭제하는 연산이 주어지면 무시
                if(pqmax.size() == 0)
                    continue;

                // 최댓값을 삭제
                if(number == 1)
                {
                    int maxnum = pqmax.poll();
                    pqmin.remove(maxnum);
                }
                // 최솟값을 삭제
                else if(number == -1)
                {
                    int minnum = pqmin.poll();
                    pqmax.remove(minnum);
                }
            }
        }

        // 빈 큐아면 [0,0]을 반환
        if(pqmax.size() == 0)
        {
            answer[0] = 0;
            answer[1] = 0;
        }
        else
        {
            answer[0] = pqmax.poll();
            answer[1] = pqmin.poll();
        }



        return answer;
    }

}
