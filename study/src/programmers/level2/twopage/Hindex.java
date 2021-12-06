package programmers.level2.twopage;

import java.util.*;

public class Hindex {

    public static void main(String[] args) {
        int[] citations = {3,0,6,1,5};

        System.out.println(solution(citations));
    }

    public static int solution(int[] citations) {
        int answer = 0;

        int n = citations.length;

        int up = 0;
        int down = 0;

        Arrays.sort(citations);


        for(int i = 0; i < n; i++)
        {
            if(citations[i] >= n - i)
            {
                answer = n-i;
                break;
            }

        }



        return answer;
    }



}
