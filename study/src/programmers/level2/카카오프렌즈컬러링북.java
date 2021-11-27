package programmers.level2;

import java.util.*;
import java.lang.*;
import java.io.*;

public class 카카오프렌즈컬러링북 {

    public static void main(String[] args) {

        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};

        System.out.println(Arrays.toString(solution(m,n,picture)));


    }

    static class dot
    {
        int number;
        int y;
        int x;

        dot(int number, int y, int x)
        {
            this.number = number;
            this.y = y;
            this.x = x;
        }
    }

    public static int[] solution(int m, int n, int[][] picture) {
        // 영역의 개수, 가장 큰 영역의 넓이
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        // 4방향 탐색
        int[] dx = {1,0,-1,0};
        int[] dy = {0,-1,0,1};

        // m : 세로, n : 가로

        Queue<dot> que = new LinkedList<dot>();

        int[][] visited = new int[m][n];

        for(int i = 0; i < m; i++) Arrays.fill(visited[i], 0);



        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(visited[i][j] == 0 && picture[i][j] != 0)
                {
                    que.add(new dot(picture[i][j], i, j));
                    int count = 1;
                    numberOfArea += 1;
                    visited[i][j] = 1;

                    while(!que.isEmpty())
                    {
                        dot d = que.poll();

                        for(int k = 0; k < 4; k++)
                        {
                            int nexty = d.y + dy[k];
                            int nextx = d.x + dx[k];

                            if(nexty >= 0 && nexty < m && nextx >= 0 && nextx < n && visited[nexty][nextx] == 0)
                            {
                                if(picture[nexty][nextx] == d.number)
                                {
                                    que.add(new dot(d.number, nexty, nextx));
                                    visited[nexty][nextx] = 1;
                                    count += 1;
                                }
                            }
                        }
                    }

                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, count);

                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }


}
