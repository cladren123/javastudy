package programmers.level2.threepage;

import java.util.*;


public class 쿼드압축후개수세기 {

    static int[] answer = new int[2];

    public static void main(String[] args) {

        int[][] arr1 = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
        int[][] arr2 = {{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}};

        System.out.println(Arrays.toString(solution(arr1)));
        System.out.println(Arrays.toString(solution(arr2)));

    }

    public static int[] solution(int[][] arr) {
        answer = new int[2];

        dfs(arr);

        return answer;
    }

    public static void dfs(int[][] arr)
    {
        int n = arr.length;
        int one = arr[0][0];

        // 종단조건
        // 칸이 1칸인 경우
        if(n == 1)
        {
            if(one == 0)
                answer[0] += 1;
            else
                answer[1] += 1;
            return;
        }

        // 0 혹은 1로만 이루어져 있는지 확인
        int flag = 1;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(one != arr[i][j])
                {
                    flag = 0;
                    break;
                }
            }
            if(flag == 0)
                break;
        }

        // 모두 같은 경우
        if(flag == 1)
        {
            if(one == 0)
                answer[0] += 1;
            else
                answer[1] += 1;

            return;
        }

        // 같지 않은 경우, 4등분으로 나눈 다음에 탐색을 계속한다.
        if(flag == 0)
        {
            int x = (int)(n / 2);

            int[][] board1 = new int[x][x];
            int[][] board2 = new int[x][x];
            int[][] board3 = new int[x][x];
            int[][] board4 = new int[x][x];

            for(int i = 0; i < x; i++)
            {
                for(int j = 0; j < x; j++)
                {
                    board1[i][j] = arr[i][j];
                    board2[i][j] = arr[i+x][j];
                    board3[i][j] = arr[i][j+x];
                    board4[i][j] = arr[i+x][j+x];

                }
            }

            dfs(board1);
            dfs(board2);
            dfs(board3);
            dfs(board4);

        }


    }

}
