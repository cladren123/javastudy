package programmers.level3.page1;

import java.util.*;
import java.lang.*;


public class 자물쇠와열쇠 {
    public static void main(String[] args) {
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = 	{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        System.out.println(solution(key, lock));
    }


    static int keyn;
    static int lockn;

    public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;

        keyn = key.length;
        lockn = lock.length;

        // 확장 작업
        int newlockn = keyn * 2 + lockn - 2;
        int[][] newlock = new int[newlockn][newlockn];
        for(int i = 0; i < lockn; i++)
            for(int j = 0; j < lockn; j++)
                newlock[i+keyn-1][j+keyn-1] = lock[i][j];



        for(int i = 0; i < keyn + lockn - 1; i++)
        {
            for(int j = 0; j < keyn + lockn - 1; j++)
            {
                // 90도씩 회전에서 맞추어본다.
                for(int k = 0; k < 4; k++)
                {
                    key = rotation(key);
                    if(check(i,j,key,newlock))
                    {
                        answer = true;
                        return answer;
                    }
                }
            }
        }



        return answer;
    }

    // 90도로 회전하는 함수
    public static int[][] rotation(int[][] array)
    {
        int n = array.length;
        int[][] rotate = new int[n][n];

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                rotate[i][j] = array[n-1-j][i];

        return rotate;
    }

    // 자물쇠가 맞는지 안맞는지 확인하는 함수
    public static boolean check(int y, int x, int[][] key, int[][] newlock)
    {
        int m = key.length;
        int newn = newlock.length;

        int[][] lock = new int[newn][newn];
        for(int i = 0; i < newn; i++)
            for(int j = 0; j < newn; j++)
                lock[i][j] = newlock[i][j];


        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < m; j++)
            {
                lock[y+i][x+j] += key[i][j];
            }
        }

//         for(int i = 0; i < newn; i++)
//             System.out.println(Arrays.toString(lock[i]));
//         System.out.println();

        for(int i = 0; i < lockn; i++)
        {
            for(int j = 0; j < lockn; j++)
            {
                if(lock[i+m-1][j+m-1] != 1)
                    return false;
            }
        }

        return true;



    }

}
