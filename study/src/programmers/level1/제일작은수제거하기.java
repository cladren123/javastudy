package programmers.level1;

import java.util.*;


public class 제일작은수제거하기 {

    public static void main(String[] args) {

        int[] arr1 = {4,3,2,1};
        int[] arr2 = {10};

        System.out.println(Arrays.toString(solution(arr1)));
        System.out.println(Arrays.toString(solution(arr2)));

    }

    public static int[] solution(int[] arr) {
        int[] answer = {};

        int n = arr.length;

        int snum = arr[0];
        for(int i = 0; i < n; i++) if(snum > arr[i]) snum = arr[i];

        // 배열 제거는 리스트를 이용한다.

        answer = new int[n-1];
        int index = 0;
        for(int i = 0; i < n; i++)
        {
            if(arr[i] == snum) continue;
            else
            {
                answer[index] = arr[i];
                index += 1;
            }
        }

        if(n == 1)
        {
            answer = new int[1];
            answer[0] = -1;
        }




        return answer;
    }
}
