package programmers.level2.page4;

import java.util.*;
import java.lang.*;

public class 최솟값만들기 {

    public static void main(String[] args) {

        int[] A1 = {1,4,2};
        int[] B1 = {5,4,4};

        int[] A2 = {1,2};
        int[] B2 = {3,4};

        System.out.println(solution(A1, B1));
        System.out.println(solution(A2, B2));

    }

    public static int solution(int[] A, int[] B)
    {
        int answer = 0;


        Arrays.sort(A);
        Arrays.sort(B);

        int n = A.length;
        int index = n-1;

        for(int i = 0; i < n; i++)
        {
            int result = 0;
            result = A[i] * B[index];
            index -= 1;
            answer += result;

        }

        return answer;
    }

}
