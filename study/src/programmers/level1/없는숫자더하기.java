package programmers.level1;

import java.util.*;
import java.lang.*;
import java.io.*;

public class 없는숫자더하기 {
    public static void main(String[] args) {
        int[] numbers1 = {1,2,3,4,6,7,8,0};
        int[] numbers2 = {5,8,4,0,6,7,9};

        System.out.println(solution(numbers1));
        System.out.println(solution(numbers2));

    }

    public static int solution(int[] numbers) {
        int answer = 0;

        int[] nlist = new int[10];

        for(int num : numbers)
        {
            nlist[num] += 1;
        }

        for(int i = 0; i < 10; i++)
        {
            if(nlist[i] == 0) answer += i;
        }

        return answer;
    }
}
