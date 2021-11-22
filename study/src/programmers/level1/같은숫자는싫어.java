package programmers.level1;

import java.util.*;
import java.lang.*;
import java.io.*;

public class 같은숫자는싫어 {

    public static void main(String[] args) {

        int[] arr1 = {1,1,3,3,0,1,1};
        int[] arr2 = {4,4,4,3,3};

        System.out.println(Arrays.toString(solution(arr1)));
        System.out.println(Arrays.toString(solution(arr2)));

    }

    public static int[] solution(int []arr) {

        ArrayList<Integer> store = new ArrayList<Integer>();

        int n = arr.length;

        int check = arr[0];
        store.add(check);

        for(int i = 0; i < n; i++)
        {
            if(check != arr[i])
            {
                check = arr[i];
                store.add(arr[i]);
            }
        }

        int m = store.size();

        int[] answer = new int[m];
        for(int i = 0; i < m; i++) answer[i] = store.get(i);

        return answer;
    }


}
