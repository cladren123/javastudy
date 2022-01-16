package programmers.level3.page3;

public class 공이동시뮬레이션 {

    public static void main(String[] args) {
        int n = 2, m = 2, x = 0, y = 0;
        int[][] queries = {{2,1},{0,1},{1,1},{0,1},{2,1}};

        System.out.println(solution(n, m, x, y, queries));

    }


    public static long solution(int n, int m, int x, int y, int[][] queries) {
        long answer = 0;

        int querysize = queries.length;

        // 0 : 열 번호 감소 -> 열 번호 증가
        // 1 : 열 번호 증가 -> 열 번호 감소
        // 2 : 행 번호 감소 -> 행 번호 증가
        // 3 : 행 번호 증가 -> 행 번호 감소

        long rowstart = x;
        long rowend = x;
        long colstart = y;
        long colend = y;

        for(int i = querysize-1 ; i >= 0; i--)
        {
            int dir = queries[i][0];
            int dist = queries[i][1];

            if(dir == 0) // 열 번호 증가
            {
                if(colstart != 0)
                    colstart = colstart + dist;

                colend = colend + dist;
                if(colend > m-1)
                    colend = m-1;
            }
            else if(dir == 1) // 열 번호 감소
            {
                colstart = colstart - dist;

                if(colstart < 0)
                    colstart = 0;

                if(colend != m-1)
                    colend = colend - dist;
            }
            else if(dir == 2) // 행 번호 증가
            {
                if(rowstart != 0)
                    rowstart = rowstart + dist;

                rowend = rowend + dist;
                if(rowend > n-1)
                    rowend = n-1;
            }
            else if(dir == 3) // 행 번호 감소
            {
                rowstart = rowstart - dist;

                if(rowstart < 0)
                    rowstart = 0;

                if(rowend != n-1)
                    rowend = rowend - dist;
            }

            if(rowstart > n-1 || rowend < 0 || colstart > m-1 || colend < 0)
                return answer;
        }

        answer = (rowend - rowstart + 1) * (colend - colstart + 1);


        return answer;
    }


}
