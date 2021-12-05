package programmers.level2.twopage;

import java.util.*;
import java.lang.*;
import java.io.*;


public class 배달 {

    public static void main(String[] args) {
        int N1 = 5;
        int[][] road1 = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        int K1 = 3;

        int N2 = 6;
        int[][] road2 = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
        int K2 = 4;

        System.out.println(solution(N1, road1, K1));
        System.out.println(solution(N2, road2, K2));

    }

    public static int solution(int N, int[][] road, int K) {
        int answer = 0;

        int[][] board = new int[N+1][N+1];
        for(int i = 0; i < N+1; i++)
            Arrays.fill(board[i], 0);

        int roadn = road.length;

        for(int i = 0; i < roadn; i++)
        {
            int start = road[i][0];
            int end = road[i][1];
            int cost = road[i][2];

            if(board[start][end] != 0) board[start][end] = Math.min(board[start][end], cost);
            else board[start][end] = cost;
            if(board[end][start] != 0) board[end][start] = Math.min(board[end][start], cost);
            else board[end][start] = cost;

        }

        // 비용을 담을 cost
        int[] cost = new int[N+1];
        Arrays.fill(cost, 0);
        cost[1] = 0;

        // 탐색
        Queue<dot> que = new LinkedList<>();

        int[] visited = new int[N+1];
        Arrays.fill(visited, 0);
        visited[1] = 1;

        que.add(new dot(1,0, visited));

        while(!que.isEmpty())
        {
            dot d = que.poll();

            // 메모리 초과 방지 : 탐색하는 비용이 이미 크면 탐색에서 제외한다.
            if(cost[d.cur] != 0 && d.cost > cost[d.cur]) continue;



            for(int i = 1; i < N+1; i++)
            {
                if(d.visited[i] == 0)
                {
                    if(board[d.cur][i] != 0)
                    {
                        int newcost = d.cost + board[d.cur][i];

                        // visited의 함정, 일일이 옮겨야 한다.
                        int[] newvisited = new int[N+1];
                        for(int k = 0; k < N+1; k++)
                            newvisited[k] = d.visited[k];

                        newvisited[i] = 1;

                        if(cost[i] == 0)
                            cost[i] = newcost;
                        else
                            cost[i] = Math.min(cost[i], newcost);

                        que.add(new dot(i, newcost, newvisited));
                    }
                }
            }

        }


        for(int i = 1; i < N+1; i++)
        {
            if(cost[i] <= K)
                answer += 1;
        }

        System.out.println(Arrays.toString(cost));


        return answer;
    }

    static class dot
    {
        int cur;
        int cost;
        int[] visited;

        public dot(int cur, int cost, int[] visited)
        {
            this.cur = cur;
            this.cost = cost;
            this.visited = visited;
        }
    }


}
