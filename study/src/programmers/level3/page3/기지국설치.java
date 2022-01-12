// 1차 제출 : 50.3점

// 2차 제출 : 70.5점
// 1부터 시작하는 범위로 바꿨더니 통과했다.

// 큰 범위의 효율성 문제가 있으면 배열을 선언하지 않고 선형시간에 마무리 해야 된다.

/*

단순 산수로 계산가능하다.
1. 기지국 범위 밖에 있을 때.
가운데 지점에 기지국을 설치한다 생각하고 탐색 지점에 1 + 2w 더한다.
2. 기지국 범위 안에 있을 때
stations에서 주어진 부분이 가운데 부분이니 탐색 지점을 stations[i] + w + 1로 이동한다.

*/

package programmers.level3.page3;

import java.util.*;

public class 기지국설치 {

    public static void main(String[] args) {
        int n = 11;
        int[] stations = {4,11};
        int w = 1;
        System.out.println(solution(n,stations,w));

    }

    public static int solution(int n, int[] stations, int w) {
        int answer = 0;

        int si = 0;
        int position = 1;

        while(position <= n)
        {
            if(si < stations.length && position >= stations[si] - w)
            {
                position = stations[si] + w + 1;
                si += 1;
            }
            else
            {
                answer += 1;
                position += w * 2 + 1;
            }


        }


        return answer;

    }


}
