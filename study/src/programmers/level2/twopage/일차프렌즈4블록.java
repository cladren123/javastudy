package programmers.level2.twopage;

import java.util.*;
import java.lang.*;
import java.io.*;

public class 일차프렌즈4블록 {

    // 2x2 블록이 지워진다. 몇개가 지워질지 출력
    // bfs로 탐색
    // 지운다음 당기기
    // bfs로 탐색
    // m : 높이, n : 폭
    // R M A F N T J C  E:공백

    static String[] newboard;

    // 방향 설정
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};

    // 정답
    static int answer;

    public static void main(String[] args) {
        int m1 = 4;
        int n1 =5;
        String[] board1 = {"CCBDE", "AAADE", "AAABF", "CCBBF"};

        int m2 = 6;
        int n2 = 6;
        String[] board2 = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};

        System.out.println(solution(m1,n1,board1));
        System.out.println(solution(m2,n2,board2));

    }

    public static int solution(int m, int n, String[] board) {
        answer = 0;

        check(m,n,board);

        return answer;
    }

    // 2x2 정사각형 탐색
    public static void check(int m, int n, String[] board)
    {
        char[][] newboard = new char[m][n];

        for(int i = 0; i < m; i++)
            newboard[i] = board[i].toCharArray();

        while(true)
        {
            // 2x2 대상이면 1로 표시
            int[][] visited = new int[m][n];
            for(int i = 0; i < m; i++)
                Arrays.fill(visited[i], 0);


            // 반복을 결정짓는 플레그
            int flag = 0;

            // 탐색
            for(int i = 0; i < m-1; i++)
            {
                for(int j = 0; j < n-1; j++)
                {
                    char one = newboard[i][j];
                    if(one == '0') continue;
                    if(one == newboard[i+1][j] && one == newboard[i][j+1] && one == newboard[i+1][j+1])
                    {
                        visited[i][j] = 1;
                        visited[i+1][j] = 1;
                        visited[i][j+1] = 1;
                        visited[i+1][j+1] = 1;
                        flag = 1;
                    }

                }
            }

            // 삭제, 0으로 표시
            for(int i = 0; i < m; i++)
            {
                for(int j = 0; j < n; j++)
                {
                    if(visited[i][j] == 1)
                    {
                        newboard[i][j] = '0';
                        answer += 1;
                    }
                }
            }

            // 비어있는 공간 내려보내기 Queue를 활용한다.
            for(int j = 0; j < n; j++)
            {
                Queue<Character> store = new LinkedList<>();

                // 반대로 집어넣는다.
                for(int i = m-1; i >= 0; i--)
                {
                    if(newboard[i][j] == '0') continue;
                    store.add(newboard[i][j]);
                }

                // twoboard에 집어넣는다.
                for(int i = m-1; i >= 0; i--)
                {
                    if(store.isEmpty())
                        newboard[i][j] = '0';
                    else
                        newboard[i][j] = store.poll();
                }
            }

            if(flag == 0)
                break;


            // System.out.println();
            // for(int i = 0; i < m; i++)
            //     System.out.println(Arrays.toString(newboard[i]));


            // while문 끝
        }





    }


}
