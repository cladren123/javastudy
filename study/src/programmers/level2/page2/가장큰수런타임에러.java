package programmers.level2.page2;

import java.util.*;
import java.lang.*;
import java.io.*;

// 프로그래머스에서 돌렸는데 런타임 에러가 발생했다. 도대체 이유를 모르겠다.
// 숫자가 중복이 되었기 때문에 map 정렬 때 에러가 발생한 것이었다.

public class 가장큰수런타임에러 {

    public static void main(String[] args) {

        int[] numbers1 = {6,10,2};
        int[] numbers2 = {3,30,34,5,9};
        int[] numbers3 = {0,0,0};

        System.out.println(solution(numbers1));
        System.out.println(solution(numbers2));
        System.out.println(solution(numbers3));
    }

    public static String solution(int[] numbers) {
        String answer = "";

        int n = numbers.length;

        String[] snum = new String[n];
        Arrays.fill(snum, "a");

        int maxnum = 0;

        for(int i = 0; i < n; i++)
        {
            String one = String.valueOf(numbers[i]);
            maxnum = Math.max(maxnum, one.length());
            snum[i] = one;
        }

        HashMap<String,Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++)
        {
            String newone = snum[i];
            Integer m = newone.length();

            String one = newone;
            int index = 0;

            for(int j = 0; j < maxnum - m; j++)
            {
                one += newone.charAt(index);
                index += 1;
                if(index >= m) index = 0;
            }
        }





        return answer;
    }

}
