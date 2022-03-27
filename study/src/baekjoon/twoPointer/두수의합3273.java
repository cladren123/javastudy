package baekjoon.twoPointer;

import java.util.*;
import java.io.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 두수의합3273 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int target = Integer.parseInt(br.readLine()), cnt = 0;

        int start = 0, end = n-1;
        
        while(start < end){
            int sum = input[start] + input[end];
            if(sum == target){
                end--; start++;
                cnt++;
            }else if(sum>target)
                end--;
            else
                start++;
        }
        System.out.println(cnt);


    }

}
