package programmers.level2.page1;

import java.util.*;
import java.lang.*;

public class 행렬테두리회전하기 {

    public static void main(String[] args) {

        int rows1 = 6;
        int columns1 = 6;
        int[][] queries1 = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};

        int rows2 = 3;
        int columns2 = 3;
        int[][] queries2 = {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}};

        int rows3 = 100;
        int columns3 = 97;
        int[][] queries3 = {{1,1,100,97}};

        System.out.println(Arrays.toString(solution(rows1, columns1, queries1)));
        System.out.println(Arrays.toString(solution(rows2, columns2, queries2)));
        System.out.println(Arrays.toString(solution(rows3, columns3, queries3)));

    }

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};

        int n = queries.length;

        int[][] board = new int[rows + 1][columns + 1];

        for(int i = 0; i < rows+1; i++)
            Arrays.fill(board[i], 0);


        // board 만들기
        int count = 1;
        for(int i = 1; i < rows+1; i++)
        {
            for(int j = 1; j < columns+1; j++)
            {
                board[i][j] = count;
                count += 1;
            }
        }

        ArrayList<Integer> store = new ArrayList<Integer>();


        for(int i = 0; i < n; i++)
        {
            int y1 = queries[i][0];
            int x1 = queries[i][1];
            int y2 = queries[i][2];
            int x2 = queries[i][3];

            // board 복사하기
            int[][] newboard = new int[rows+1][columns+1];

            for(int row = 0; row < rows+1; row++)
                for(int column = 0; column < columns+1; column++)
                    newboard[row][column] = board[row][column];


            int smallnum = board[y1][x1];

            // 테두리 회전 구현하기
            for(int k = x1 + 1; k <= x2; k++){
                newboard[y1][k] = board[y1][k-1];
                smallnum = Math.min(smallnum, newboard[y1][k]);
            }


            for(int k = y1 + 1; k <= y2; k++){
                newboard[k][x2] = board[k-1][x2];
                smallnum = Math.min(smallnum, newboard[k][x2]);
            }


            for(int k = x2-1; k >= x1; k--){
                newboard[y2][k] = board[y2][k+1];
                smallnum = Math.min(smallnum, newboard[y2][k]);
            }


            for(int k = y2 - 1; k >= y1; k--){
                newboard[k][x1] = board[k+1][x1];
                smallnum = Math.min(smallnum, newboard[k][x1]);
            }

            store.add(smallnum);

            // 바뀐 것을 원본에 적용
            board = newboard;

            // for(int index = 0; index < rows+1; index++)
            //     System.out.println(Arrays.toString(board[index]));

        }

        // System.out.println(store);

        int m = store.size();

        answer = new int[m];

        for(int i = 0; i < m; i++)
            answer[i] = store.get(i);

        return answer;
    }
}
