package programmers.level1;

import java.util.*;
import java.lang.*;
import java.io.*;

public class 일차비밀지도 {

    public static void main(String[] args) {

        int n1 = 5;
        int[] arr11 = {9,20,28,18,11};
        int[] arr21 = {30,1,21,17,28};

        int n2 = 6;
        int[] arr12 = {46,33,33,22,31,50};
        int[] arr22 = {27,56,19,14,14,10};

        System.out.println(Arrays.toString(solution(n1, arr11, arr21)));
        System.out.println(Arrays.toString(solution(n2, arr12, arr22)));

    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int i = 0; i < n; i++)
        {
            StringBuffer one = new StringBuffer();
            one.append(Integer.toBinaryString(arr1[i]));
            StringBuffer two = new StringBuffer();
            two.append(Integer.toBinaryString(arr2[i]));

            while(one.length() != n) one.insert(0, "0");
            while(two.length() != n) two.insert(0, "0");

            StringBuffer three = new StringBuffer();

            for(int j = 0; j < n; j++)
            {
                if(one.charAt(j) == '1')
                {
                    three.append('#');
                    continue;
                }
                if(two.charAt(j) == '1')
                {
                    three.append('#');
                    continue;
                }
                three.append(' ');
            }

            answer[i] = three.toString();

        }





        return answer;
    }

}
