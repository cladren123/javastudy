package programmers.level3.page1;

import java.util.*;

// 순위를 확정짓기 위해서는 n-1개의 경기결과가 필요합니다.

// 20점..
// 60점
// for문의 범위를 바로잡았더니 60점
// 90점
// 업데이트를 한 번 더 했더니 90점..
// 100점
// 업데이트 for문을 한 번 더 했더니 100점..

public class 순위 {

    public static void main(String[] args) {
        int n = 5;
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};

        System.out.println(solution(n, results));

    }

    public static int solution(int n, int[][] results) {
        int answer = 0;

        int[][] board = new int[n+1][n+1];

        int resultn = results.length;


        // 3번은 업데이트 해야 한다.
        // 플로이드-와샬 알고리즘 : 각 정점에서 모든 정점으로 가는 최소 거리를 표현
        // 3번 업데이트를 해줘야 한다.

        // 처음 값 기입
        for(int i = 0; i < resultn; i++)
        {
            int w = results[i][0];
            int l = results[i][1];

            board[w][l] = 1;
            board[l][w] = -1;
        }

        // 업데이트 1
        for(int i = 0; i < resultn; i++)
        {
            int w = results[i][0];
            int l = results[i][1];

            for(int j = 1; j < n+1; j++)
            {
                if(board[l][j] == 1)
                    board[w][j] = 1;

                if(board[w][j] == -1)
                    board[l][j] = -1;
            }
        }

        // 업데이트2
        for(int i = 0; i < resultn; i++)
        {
            int w = results[i][0];
            int l = results[i][1];

            for(int j = 1; j < n+1; j++)
            {
                if(board[l][j] == 1)
                    board[w][j] = 1;

                if(board[w][j] == -1)
                    board[l][j] = -1;
            }
        }

        // 업데이트 3
        for(int i = 0; i < resultn; i++)
        {
            int w = results[i][0];
            int l = results[i][1];

            for(int j = 1; j < n+1; j++)
            {
                if(board[l][j] == 1)
                    board[w][j] = 1;

                if(board[w][j] == -1)
                    board[l][j] = -1;
            }
        }


        // 승부수가 n-1개인 선수의 수를 세어 정답 도출
        for(int i = 1; i < n+1; i++)
        {
            int result = 0;
            for(int j = 1; j < n+1; j++)
            {
                if(board[i][j] == 0)
                    result += 1;
            }
            if(result == 1)
                answer += 1;
        }

        return answer;
    }
}
