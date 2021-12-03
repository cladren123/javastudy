package programmers.level2.twopage;

import java.util.*;
import java.lang.*;

public class 게임맵최단거리 {

    public static void main(String[] args) {

        int[][] maps1 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        int[][] maps2 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};

        System.out.println(solution(maps1));
        System.out.println(solution(maps2));
        
    }

    public static int solution(int[][] maps) {
        int answer = 0;

        // 세로
        int n = maps.length;

        // 가로
        int m = maps[0].length;

        // 중복 여부 파악
        int[][] visited = new int[n][m];
        for(int i = 0; i < n; i++)
        {
            Arrays.fill(visited[i], 0);
        }

        Queue<dot> que = new LinkedList<>();

        // 시작점 넣기
        que.add(new dot(0,0,1));
        visited[0][0] = 1;

        int[] dx = {1,0,-1,0};
        int[] dy = {0,-1,0,1};

        while(!que.isEmpty())
        {
            dot d = que.poll();

            for(int i = 0; i < 4; i++)
            {
                int ny = d.y + dy[i];
                int nx = d.x + dx[i];

                if(ny < n && ny >= 0 && nx < m && nx >= 0)
                {
                    if(visited[ny][nx] == 0 && maps[ny][nx] == 1)
                    {
                        if(ny == n-1 && nx == m - 1)
                            return answer = d.count+1;

                        visited[ny][nx] = 1;
                        que.add(new dot(ny,nx,d.count+1));
                    }
                }
            }
        }

        answer = -1;


        return answer;
    }



    static class dot{
        int y;
        int x;
        int count;

        public dot(int y, int x, int count)
        {
            this.y = y;
            this.x = x;
            this.count = count;
        }

    }

}
