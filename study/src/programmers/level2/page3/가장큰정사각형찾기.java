package programmers.level2.page3;

public class 가장큰정사각형찾기 {

    public static void main(String[] args) {

        int[][] board1 = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
        int[][] board2 = {{0,0,1,1},{1,1,1,1}};

        System.out.println(solution(board1));
        System.out.println(solution(board2));

    }

    public static int solution(int [][]board)
    {
        int answer = 0;

        // DP로 탐색

        int n = board.length;
        int m = board[0].length;

        int[][] dp = new int[n+1][m+1];

        for(int i = 1; i < n+1; i++)
        {
            for(int j = 1; j < m+1; j++)
            {
                int one = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]));
                if(board[i-1][j-1] == 1)
                    dp[i][j] = one + board[i-1][j-1];
                else
                    dp[i][j] = 0;
                answer = Math.max(answer, dp[i][j]);
            }
        }

        answer = answer * answer;

        return answer;
    }

}
