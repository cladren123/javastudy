package programmers.kakoblind2022;

import java.util.*;

public class 양궁대회 {

    public static void main(String[] args) {
        int n = 5;
        int[] info = 	{2,1,1,1,0,0,0,0,0,0,0};

        System.out.println(Arrays.toString(solution(n, info)));
    }

    static int[] res = {-1};
    static int[] lion;
    static int max = -1000;

    public static void dfs(int[] info, int cnt, int n)
    {
        if(cnt == n)
        {
            int apeachPoint = 0;
            int lionPoint = 0;

            for(int i = 0; i <= 10; i++)
            {
                if(info[i] != 0 || lion[i] != 0)
                {
                    if(info[i] < lion[i])
                        lionPoint += 10 - i;
                    else
                        apeachPoint += 10 - i;
                }
            }

            if(lionPoint > apeachPoint)
            {
                if(lionPoint - apeachPoint >= max)
                {
                    res = lion.clone();
                    max = lionPoint - apeachPoint;
                }

            }

            return;

        }


        for(int j = 0; j <= 10 && lion[j] <= info[j]; j++)
        {
            lion[j]++;
            dfs(info, cnt+1, n);
            lion[j]--;
        }


    }

    public static int[] solution(int n, int[] info) {


        lion = new int[11];

        dfs(info, 0, n);

        return res;
    }


}
