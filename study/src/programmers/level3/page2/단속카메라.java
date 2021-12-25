package programmers.level3.page2;

import java.util.*;

public class 단속카메라 {

    public static void main(String[] args) {

        int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};

        System.out.println(solution(routes));

    }

    public static int solution(int[][] routes) {
        int answer = 1;

        // 나간 시점을 기준으로 오름차순 정렬
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);

        int n = routes.length;


        int min = routes[0][1];
        int count = 0;

        for(int i = 0; i < n; i++)
        {
            if(min < routes[i][0])
            {
                answer += 1;
                min = routes[i][1];
            }
        }






        return answer;
    }

}
