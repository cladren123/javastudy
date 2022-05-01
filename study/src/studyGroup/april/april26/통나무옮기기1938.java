package studyGroup.april.april26;

// https://www.acmicpc.net/problem/1938

import java.util.*;
import java.lang.*;
import java.io.*;

public class 통나무옮기기1938 {

    static int n;
    static int[][] board;

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};

    static int[][][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        board = new int[n][n];

        // 통나무
        int[][] logSpot = new int[3][2];
        int[][] endSpot = new int[3][2];
        int index = 0;

        for(int i = 0; i < n; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++)
            {

                board[i][j] = Integer.parseInt(st.nextToken());

                if(board[i][j] == 'B')
                {
                    logSpot[index][0] = i;
                    logSpot[index][1] = j;
                }

                if(board[i][j] == 'E')
                {
                    endSpot[index][0] = i;
                    endSpot[index][1] = j;
                }

            }
        }

        // 가장 왼쪽, 가장 위쪽을 기준으로 시작
        visited = new int[n][n][2];
        int head = 0; // 0은 가로, 1은 세로
        if(logSpot[0][0] == logSpot[1][0])
        {
            head = 1;
        }

        Queue<dot> que = new LinkedList<>();
        que.add(new dot(head, logSpot, 0));


        System.out.println(Arrays.toString(logSpot));






    }


   static class dot
    {
        int head; // 가로 세로 여부
        int[][] logSpot;
        int count;

        dot(int head, int[][] logSpot, int count)
        {
            this.head = head;
            this.logSpot = logSpot;
            this.count = count;
        }
    }



}
