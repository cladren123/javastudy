package programmers.level2;

import java.util.*;
import java.lang.*;
import java.io.*;

public class 튜플 {

    public static void main(String[] args) {

        String s1 = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        String s2 = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        String s3 = "{{20,111},{111}}";
        String s4 = "{{123}}";
        String s5 = "{{4,2,3},{3},{2,3,4,1},{2,3}}";

        System.out.println(Arrays.toString(solution(s1)));
        System.out.println(Arrays.toString(solution(s2)));
        System.out.println(Arrays.toString(solution(s3)));
        System.out.println(Arrays.toString(solution(s4)));
        System.out.println(Arrays.toString(solution(s5)));
    }

    public static int[] solution(String s) {
        int[] answer = {};

        int n = s.length();


        // trim 공백제거
        s = s.replaceAll("[{}]", "").trim();

        String[] hubo = s.split(",");



        HashMap<String, Integer> map = new HashMap<>();

        for(String one : hubo)
        {
            map.put(one, map.getOrDefault(one, 0) + 1);
        }

        // value 정렬
        Map<Integer, String> sorted = new TreeMap<Integer, String>(Collections.reverseOrder());

        for(String one : map.keySet())
        {
            sorted.put(map.get(one), one);
        }


        int m = sorted.size();

        answer = new int[m];
        Arrays.fill(answer, 0);

        int index = 0;

        for(Integer one : sorted.keySet())
        {
            answer[index] = Integer.parseInt(sorted.get(one));
            index += 1;
        }



        return answer;
    }

}
