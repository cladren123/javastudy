package programmers.level2.threepage;

import java.util.*;
import java.lang.*;

public class 전력망을둘로나누기 {

    public static void main(String[] args) {
        int n1 = 9;
        int[][] wires1 = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};

        int n2 = 4;
        int[][] wires2 = {{1,2},{2,3},{3,4}};

        int n3 = 7;
        int[][] wires3 = {{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}};

        System.out.println(solution(n1,wires1));
        System.out.println(solution(n2,wires2));
        System.out.println(solution(n3,wires3));

    }

    public static int solution(int n, int[][] wires) {
        int answer = n;
        int wn = wires.length;

        // 탐색에 사용할 Queue
        Queue<Integer> que = new LinkedList<>();

        int s = 0;
        int e = 0;


        for(int i = 0; i < wn; i++)
        {
            int[][] board = new int[n+1][n+1];
            int[] visited = new int[n+1];
            int result = 0;

            // 하나씩 뺀 상태에서 탐색
            for(int j = 0; j < wn; j++)
            {
                if(i == j) continue;
                s = wires[j][0];
                e = wires[j][1];

                board[s][e] = 1;
                board[e][s] = 1;
            }

            // 탐색 시작
            que.add(s);
            visited[s] = 1;
            result += 1;

            while(!que.isEmpty())
            {
                int cur = que.poll();
                for(int k = 0; k < n+1; k++)
                {
                    if(board[cur][k] == 1 && visited[k] == 0)
                    {
                        que.add(k);
                        result += 1;
                        visited[k] = 1;
                    }

                }
            }

            int m = n - result;
            int hubo = Math.abs(m-result);

            answer = Math.min(answer,hubo);

        }

        return answer;
    }

}
