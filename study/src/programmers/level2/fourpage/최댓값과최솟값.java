package programmers.level2.fourpage;

import java.util.*;

public class 최댓값과최솟값 {

    public static void main(String[] args) {

        String s1 = "1 2 3 4";
        String s2 = "-1 -2 -3 -4";
        String s3 = "-1 -1";

        System.out.println(solution(s1));
        System.out.println(solution(s2));
        System.out.println(solution(s3));


    }

    public static String solution(String s) {
        String answer = "";

        String[] sp = s.split(" ");

        int n = sp.length;

        int[] arr = new int[n];

        // -가 포함된 문자열도 정수로 변환이 된다.
        for(int i = 0; i < n; i++)
        {
            arr[i] = Integer.parseInt(sp[i]);
        }


        int maxone = arr[0];
        int minone = arr[0];

        for(int i = 0; i < n; i++)
        {
            maxone = Math.max(maxone, arr[i]);
            minone = Math.min(minone, arr[i]);
        }

        answer += String.valueOf(minone) + " " + String.valueOf(maxone);

        return answer;
    }


}
