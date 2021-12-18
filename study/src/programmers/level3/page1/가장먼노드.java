package programmers.level3.page1;

import java.util.*;
import java.lang.*;
import java.io.*;

public class 가장먼노드 {

    public static void main(String[] args) {
        int n = 6;
        int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        System.out.println(solution(n, vertex));

    }

    public static int solution(int n, int[][] edge) {
        int answer = 0;

        boolean[][] board = new boolean[n+1][n+1];

        for(int i = 0; i < edge.length; i++)
        {
            int s = edge[i][0];
            int e = edge[i][1];

            board[s][e] = true;
            board[e][s] = true;
        }

        Queue<Integer> que = new LinkedList<>();
        que.add(1);

        // 거리를 담을 리스트
        int[] visited = new int[n+1];
        Arrays.fill(visited, -1);
        visited[1] = 0;
        int maxnum = 0;

        while(!que.isEmpty())
        {
            int cur = que.poll();

            for(int i = 1; i < n+1; i++)
            {
                if(board[cur][i] == true && visited[i] == -1)
                {
                    visited[i] = visited[cur] + 1;
                    que.add(i);
                    maxnum = Math.max(maxnum, visited[i]);
                }

            }
        }

        // System.out.println(Arrays.toString(visited));
        // System.out.println(maxnum);

        for(int i = 1; i < n+1; i++)
            if(visited[i] == maxnum)
                answer += 1;

        return answer;

    }


}
