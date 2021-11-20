package programmers.level1;

import java.util.*;
import java.lang.*;
import java.io.*;

public class 두개뽑아서더하기 {
    public static void main(String[] args) {

        int[] numbers1 = {2,1,3,4,1};

        int[] numbers2 = {5,0,2,7};

        System.out.println(Arrays.toString(solution((numbers1))));
        System.out.println(Arrays.toString(solution((numbers2))));


    }

    public static int[] solution(int[] numbers) {

        ArrayList<Integer> deck = new ArrayList<Integer>();
        int n = numbers.length;

        for(int i = 0; i < n-1; i++)
        {
            for(int j = i+1; j < n; j++)
            {
                int one = numbers[i] + numbers[j];
                if(!deck.contains(one)) deck.add(one);
            }
        }

        int m = deck.size();
        int[] answer = new int[m];

        for(int i = 0; i < m; i++) answer[i] = deck.get(i);

        Arrays.sort(answer);

        return answer;
    }

}
