package programmers.level3.page3;

import java.util.*;

public class 숫자게임 {

    public static void main(String[] args) {

        int[] A = {5,1,3,7};
        int[] B = {2,2,6,8};

        System.out.println(solution(A,B));

    }

    public static int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int n = A.length;
        int index = n-1;

        for(int i = n-1; i >= 0; i--)
        {
            if(A[i] < B[index])
            {
                answer += 1;
                index -= 1;
            }
        }

        return answer;
    }

}
