package programmers.level2.onepage;

import java.util.*;
import java.lang.*;
import java.io.*;

public class 거리두기확인하기 {


    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};

    static class dot
    {
        int y;
        int x;
        int count;

        dot(int y, int x, int count)
        {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }



    public static int check(String[] caseone)
    {
        int result = 1;

        // 방문 여부 파악
        int[][] visited = new int[5][5];
        for(int i = 0; i < 5; i++)
            Arrays.fill(visited[i], 0);




        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                // 사람이 있으면 거리두기를 지키는지 확인
                if(caseone[i].charAt(j) == 'P')
                {
                    Queue<dot> que = new LinkedList<>();
                    que.add(new dot(i,j,0));
                    visited[i][j] = 1;

                    while(!que.isEmpty())
                    {
                        dot d = que.poll();

                        // 4방향 탐색
                        for(int di = 0; di < 4; di++)
                        {
                            int ny = d.y + dy[di];
                            int nx = d.x + dx[di];

                            if(ny >= 0 && ny < 5 && nx >= 0 && nx < 5 && visited[ny][nx] == 0)
                            {
                                visited[ny][nx] = 1;
                                int newcount = d.count + 1;

                                if(caseone[ny].charAt(nx) == 'O' && newcount < 2)
                                {
                                    que.add(new dot(ny,nx,newcount));
                                }

                                if(caseone[ny].charAt(nx) == 'X') continue;
                                if(caseone[ny].charAt(nx) == 'P') {
                                    return 0;
                                }
                            }
                        }
                    }

                }


            }
        }




        return result;
    }



    public static int[] solution(String[][] places) {
        int[] answer = {};

        // bfs를 이용해 탐색한다.

        int n = places.length;

        ArrayList<Integer> alist = new ArrayList<Integer>();


        for(int i = 0; i < n; i++)
        {
            alist.add(check(places[i]));
        }

        // alist.add(check(places[0]));

        answer = new int[n];
        for(int i = 0; i < n; i++)
            answer[i] = alist.get(i);




        return answer;
    }

    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        System.out.println(Arrays.toString(solution(places)));
    }


}
