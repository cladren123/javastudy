package programmers.level3.page2;

import java.util.*;

public class 카드짝맞추기 {

    public static void main(String[] args) {

    }

    static int n;
    static int[] store;
    static boolean[] visited;
    static int[][] board;
    static int r;
    static int c;

    public static int solution(int[][] board, int r, int c) {
        int answer = 0;

        n = 0;
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                if(n < board[i][j])
                    n = board[i][j];
            }
        }

        this.board = board.clone();
        this.r = r;
        this.c = c;

        // 탐색 경우의 수를 구하는 함수
        store = new int[n];
        visited = new boolean[n];
        dfs(0);


        return answer;
    }

    // 탐색 순서의 경우의 수를 구하는 함수
    public static void dfs(int stage)
    {
        if(stage == n)
        {
            bfs();
            return;
        }

        for(int i = 0; i < n; i++)
        {
            if(visited[i] == false)
            {
                visited[i] = true;
                store[stage] = i+1;
                dfs(stage+1);
                visited[i] = false;
            }
        }
    }
    // 탐색 순서의 경우의 수를 구하는 함수

    // 탐색 순서에 맞게 탐색하는 함수
    public static void bfs()
    {
        // r : row x좌표 c : column y좌표




        return;
    }

    // 좌표 이동하는데 누른 횟수 구하기
    public static void move(int x1, int y1, int x2, int y2)
    {



    }

}
