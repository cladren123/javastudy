package programmers.level1;

import java.util.*;
import java.lang.*;
import java.io.*;

public class 체육복 {

    public static void main(String[] args) {

        int n1 = 5;
        int[] lost1 = {2,4};
        int[] reserve1 = {1,3,5};

        int n2 = 5;
        int[] lost2 = {2,4};
        int[] reserve2 = {3};

        int n3 = 3;
        int[] lost3 = {3};
        int[] reserve3 = {1};

        System.out.println(solution(n1, lost1, reserve1));
        System.out.println(solution(n2, lost2, reserve2));
        System.out.println(solution(n3, lost3, reserve3));


    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] cloth = new int[n];
        Arrays.fill(cloth, 1);

        for(int i : lost)
        {
            cloth[i-1] -= 1;
        }

        for(int i : reserve)
        {
            cloth[i-1] += 1;
        }

        for(int i = 0; i < n; i++)
        {
            if(cloth[i] == 2)
            {
                if(i-1 >= 0 && cloth[i-1] == 0)
                {
                    cloth[i] -= 1;
                    cloth[i-1] += 1;
                    continue;
                }

                if(i+1 < n && cloth[i+1] == 0)
                {
                    cloth[i] -= 1;
                    cloth[i+1] += 1;
                }
            }
        }

        for(int i : cloth)
        {
            if(i >= 1) answer += 1;
        }




        return answer;
    }
}
