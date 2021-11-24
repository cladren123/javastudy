package programmers.level1;

import java.util.*;

public class 평균구하기 {

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4};
        int[] arr2 = {5,5};

        System.out.println(solution(arr1));
        System.out.println(solution(arr2));
    }

    public static double solution(int[] arr) {
        double answer = 0;

        double sumnum = 0;

        for(int num : arr) sumnum += num;

        answer = sumnum / (double)arr.length;

        return answer;
    }
}
