package baekjoon.recursion;

import java.lang.*;
import java.io.*;
import java.util.*;

public class NO10872 {


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // dp 로 해결하자

        // n의 범위는 12이하 이다.
        int[] arr = new int[13];

        Arrays.fill(arr, 1);

        for(int i = 2; i < 13; i++){
            arr[i] = arr[i-1]*i;
        }

        System.out.println(arr[n]);

    }
}
