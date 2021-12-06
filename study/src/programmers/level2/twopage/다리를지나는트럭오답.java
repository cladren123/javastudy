package programmers.level2.twopage;

import java.util.*;

// 시발 정답이 아닌 것 왜 정답이 아닌지 모르겠다.
// 시발 시간 아깝다.

public class 다리를지나는트럭오답 {

    public static void main(String[] args) {

        int bridge_length1 = 2;
        int weight1 = 10;
        int[] truck_weights1 = {7,4,5,6};

        int bridge_length2 = 100;
        int weight2 = 100;
        int[] truck_weights2 = {10};

        int bridge_length3 = 100;
        int weight3 = 100;
        int[] truck_weights3 = {10,10,10,10,10,10,10,10,10,10};

        System.out.println(solution(bridge_length1, weight1, truck_weights1));
        System.out.println(solution(bridge_length2, weight2, truck_weights2));
        System.out.println(solution(bridge_length3, weight3, truck_weights3));

    }

    // 문제에서 정해진 범위 내에서 다루어야 한다.
    // 순서가 중요하다 -> 먼저 빠저나간 다음에 채워야 한다.

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 0;

            Queue<Integer> bridge = new LinkedList<>();

            // 트럭의 개수
            int n = truck_weights.length;

            // 다리 위의 총 무게
            int wsum = 0;

            // 트럭의 순서
            int index = 0;


            while(index != n)
            {
                answer += 1;


                // 다리 크기가 같다면 앞에 것을 뺀다.
                if(bridge.size() == bridge_length)
                {
                    int fallone = bridge.poll();
                    wsum -= fallone;
                }

                // 트럭이 다음에 올 수 없을 때, 0을 추가
                if(index < n && truck_weights[index] + wsum > weight)
                {
                    bridge.add(0);
                }

                // 트럭의 무게가 다리에 올릴 수 있는 경우
                if(wsum + truck_weights[index] <= (weight))
                {
                    bridge.add(truck_weights[index]);
                    wsum += truck_weights[index];
                    index += 1;
                }



            }

            // 마지막 것
            answer += bridge_length;


            return answer;
        }



}
