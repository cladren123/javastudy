package programmers.level1;

import java.util.*;
import java.lang.*;
import java.io.*;

public class 나누어떨어지는숫자배열 {

    public static void main(String[] args) {

        int[] arr1 = {5,9,7,10};
        int divisor1 = 5;

        int[] arr2 = {2,36,1,3};
        int divisor2 = 1;

        int[] arr3 = {3,2,6};
        int divisor3 = 10;

        System.out.println(Arrays.toString(solution(arr1, divisor1)));
        System.out.println(Arrays.toString(solution(arr2, divisor2)));
        System.out.println(Arrays.toString(solution(arr3, divisor3)));

    }

    public static int[] solution(int[] arr, int divisor) {
        int[] answer = {};

        ArrayList<Integer> store = new ArrayList<Integer>();

        Arrays.sort(arr);
        int n = arr.length;

        for(int i = 0; i < n; i++)
        {
            if(arr[i] % divisor == 0) store.add(arr[i]);
        }

        int m = store.size();
        answer = new int[m];
        for(int i = 0; i < m; i++) answer[i] = store.get(i);

        if(m==0)
        {
            answer = new int[1];
            answer[0] = -1;
        }

        return answer;
    }

}
