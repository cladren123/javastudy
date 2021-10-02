package baekjoon.dfs;

// 백준 2178 미로탐색

import java.util.*;
import java.lang.*;
import java.io.*;

// dfs 시간초과

/*
bfs 사용할 때
1. 최소 비용 문제
2. 간선의 가중치 1인 경우
3. 정점과 간선의 개수가 적다. 
 */


public class no2178second {
    // n : 세로 m : 가로
    static int n,m;
    static int answer = 100001;
    static int[][] board;
    static int[][] visited;

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};

    public static void dfs2178(int y, int x, int count){
        // 종단조건
        if(y == n-1 && x == m-1){
            answer = Math.min(answer, count);
            return;
        }

        for(int i = 0; i < 4; i++){
            int nexty = y + dy[i];
            int nextx = x + dx[i];

            if(nexty >= 0 && nexty < n && nextx >= 0 && nextx < m){
                if(visited[nexty][nextx] == 0 && board[nexty][nextx] == 1){
                    visited[nexty][nextx] = 1;
                    dfs2178(nexty, nextx, count + 1);
                    visited[nexty][nextx] = 0;

                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        // 입력단
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        StringTokenizer st = new StringTokenizer(line, " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new int[n][m];

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < m; j++){
                board[i][j] = str.charAt(j) - '0';
            }
        }

        // visited 배열 0으로 초기화
        for(int i = 0; i < n; i++){
            Arrays.fill(visited[i], 0);
        }

        visited[0][0] = 1;
        dfs2178(0,0,1);
        System.out.print(answer);
















    }
}
