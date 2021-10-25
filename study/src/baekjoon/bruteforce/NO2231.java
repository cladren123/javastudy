package baekjoon.bruteforce;

import java.lang.*;
import java.io.*;
import java.util.*;

// 분해합

public class NO2231 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int result = 0;

        for(int i = 0; i < n+1; i++){
            int number = i;
            int sum = 0;

            while(number != 0) {
                sum += number % 10;
                number /= 10;
            }

            if(sum + i == n){
                result = i;
                break;
            }

        }

        System.out.println(result);




    }
}
