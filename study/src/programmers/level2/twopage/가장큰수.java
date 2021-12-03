package programmers.level2.twopage;

import java.util.*;

public class 가장큰수 {

    public static void main(String[] args) {

        int[] numbers1 = {6,10,2};
        int[] numbers2 = {3,30,34,5,9};

        System.out.println(solution(numbers1));
        System.out.println(solution(numbers2));


    }

    public static String solution(int[] numbers) {


        String[] result = new String[numbers.length];

        // 문자열 변환
        for(int i = 0; i < numbers.length; i++)
        {
            result[i] = String.valueOf(numbers[i]);
        }

        // 정렬
        Arrays.sort(result, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2)
            {
                return ((o2 + o1).compareTo(o1 + o2));
            }

        });

        if(result[0].equals("0"))
        {
            return "0";
        }

        String answer = "";

        // 정렬된 문자 하나로 합치기
        for(String a : result)
        {
            answer += a;
        }


        return answer;
    }
}
