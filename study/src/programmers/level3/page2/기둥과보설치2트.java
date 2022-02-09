package programmers.level3.page2;

import java.util.*;

public class 기둥과보설치2트 {

    public static void main(String[] args) {

        int n = 5;
        int[][] build_frame = {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};

        int[][] result = solution(n,build_frame);

        for(int[] one : result)
            System.out.println(Arrays.toString(one));

    }

    static boolean[][] pillar; // 기둥
    static boolean[][] girdir; // 보
    static int n;

    public static int[][] solution(int n1, int[][] build_frame) {

        n = n1;

        // 해당 위치에 있으면 true, 없으면 false
        pillar = new boolean[n+1][n+1];
        girdir = new boolean[n+1][n+1];

        int count = 0;

        for(int[] one : build_frame)
        {
            int x = one[0];
            int y = one[1];
            int type = one[2]; // 0 : 기둥  1 : 보
            int build = one[3]; // 0 : 삭제  1 : 설치

            // 기둥
            if(type == 0)
            {
                // 설치
                if(build == 1)
                {
                    if(pillarCheck(x, y))
                    {
                        pillar[x][y] = true;
                        count++;
                    }
                }

                // 제거
                if(build == 0)
                {
                    pillar[x][y] = false;
                    if(canDelete() == false)
                    {
                        pillar[x][y] = true;
                    }
                    else count--;
                }
            }


            // 보
            if(type == 1)
            {
                // 설치
                if(build == 1)
                {
                    if(girdirCheck(x,y))
                    {
                        girdir[x][y] = true;
                        count++;
                    }
                }

                if(build == 0)
                {
                    girdir[x][y] = false;
                    if(canDelete() == false)
                    {
                        girdir[x][y] = true;
                    }
                    else count--;
                }
            }
        }

        int[][] answer = new int[count][3];

        int index = 0;

        for(int i = 0; i < n+1; i++)
        {
            for(int j = 0; j < n+1; j++)
            {
                if(pillar[i][j])
                {
                    answer[index][0] = i;
                    answer[index][1] = j;
                    answer[index++][2] = 0;
                }
                if(girdir[i][j])
                {
                    answer[index][0] = i;
                    answer[index][1] = j;
                    answer[index++][2] = 1;
                }
            }
        }

        return answer;
    }

    // 삭제 할 수 있는지
    public static boolean canDelete()
    {
        for(int i = 0; i <= n; i++)
        {
            for(int j = 0; j <= n; j++)
            {
                if(pillar[i][j] && pillarCheck(i,j) == false) return false;
                else if(girdir[i][j] && girdirCheck(i,j) == false) return false;
            }
        }

        return true;
    }

    // 기둥 설치 : 바닥 위, 보의 한쪽 끝, 다른 기둥 위에
    public static boolean pillarCheck(int x, int y)
    {
        // 바닥 위
        if(y == 0) return true;

            // 다른 기둥 위에
        else if(y > 0 && pillar[x][y-1]) return true;

            // 보의 한쪽 끝
            // 왜 런타임에러가 발생하는거지???????????  -> && 묵이는게 중요하다.
        else if(x > 0 && girdir[x-1][y] || girdir[x][y]) return true;

        return false;
    }

    // 보 설치 : 한 쪽 끝 부분이 기둥 위, 양쪽 끝 부분이 다른 보와 동시에 연결
    public static boolean girdirCheck(int x, int y)
    {
        if(y > 0 && pillar[x][y-1] || pillar[x+1][y-1]) return true;
        else if(x > 0 && girdir[x-1][y] && girdir[x+1][y]) return true;

        return false;
    }



}
