package programmers.level3.page1;

import java.util.*;


// 보석이 어떤 종류가 있는지부터 확인해야할거 같은데

// 1차 11점
// dfs를 활용했지만 시간초과가 발생했다.

// 2차 100점
// 구글찬스

// 구간을 하나씩 늘려가면서 탐색한다. 구간의 첫번째 보석이 있으면 뺀다.
// 정하면서 보석이 모두 들어와있는지 map과 set으로 확인한다.
// 구간 변수를 통해 기존의 정답보다 길이가 짧은 것만



public class 보석쇼핑 {

    public static void main(String[] args) {
        String[] gems = {"AA", "AB", "AC", "AA", "AC"};
        System.out.println(Arrays.toString(solution(gems)));
    }

    public static int[] solution(String[] gems) {
        int[] answer = new int[2];

        HashMap<String, Integer> store = new HashMap<>(); // 보석별 갯수 저장
        HashSet<String> set = new HashSet<>(Arrays.asList(gems)); // 보석의 종류 확인
        Queue<String> interval = new LinkedList<>(); // 간격


        int length = Integer.MAX_VALUE;

        int intervalstart = 0; // 구간 시작 지점
        int tempintervalstart = 0;  // 계산용 구간 시작 지점

        for(int i = 0; i < gems.length; i++)
        {
            String gem = gems[i];

            store.put(gem, store.getOrDefault(gem, 0) + 1);
            interval.offer(gem);

            while(true)
            {
                String temp = interval.peek(); // 구간의 첫번째 보석, peek는 참조만 할 뿐 빼진 않는다.

                // 구간 첫번째 보석이 2개 이상인 경우
                if(store.get(temp) > 1)
                {
                    // 첫번째 보석 제거
                    store.put(temp, store.get(temp) -1);  // map에서 갯수를 하나 뺌
                    interval.poll(); // 구간 queue의 첫번쨰 보석을 뺀다.

                    // 구간시작지점을 다음지점으로 변경
                    tempintervalstart++;
                }
                else
                    break;
            }

            // store와 set을 비교해 모든 보석이 들어와있는지 확인한다.
            // 모든 보석이 구간안에 들어오고 기존의 정답보다 길이가 짧아야 정답으로 갱신된다.
            if(store.size() == set.size() && length > interval.size())
            {
                length = interval.size();
                intervalstart = tempintervalstart;
            }
        }

        answer[0] = intervalstart + 1;
        answer[1] = intervalstart + length;





        return answer;

    }



}
