package programmers.level2.twopage;

import java.util.*;
import java.lang.*;
import java.io.*;

public class 순위검색 {

    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

        System.out.println(Arrays.toString(solution(info, query)));
    }

    public static int[] solution(String[] info, String[] query) {
        int[] answer = {};

        int n = info.length;
        int m = info.length;

        // 언어, 회원번호
        HashMap<String, List<Integer>> language = new HashMap<>();

        // 직군, 회원번호
        HashMap<String, List<Integer>> worker = new HashMap<>();

        // 경력 회원번호
        HashMap<String, List<Integer>> career = new HashMap<>();

        // 소울푸드 회원번호
        HashMap<String, List<Integer>> food = new HashMap<>();

        // 회원번호 점수
        HashMap<Integer, Integer> score = new HashMap<>();


        List<Integer> list = new ArrayList<>();
        list.add(0);
        language.put("some", list);
        System.out.println(language);

        language.get("some").add(1);
        System.out.println(language);

        language.put("be", language.get("some"));
        System.out.println(language);




        for(int i = 0; i < n; i++)
        {
            String[] caseone = info[i].split(" ");
            String lan = caseone[0];
            String work = caseone[1];
            String car = caseone[2];
            String soul = caseone[3];
            Integer sco = Integer.valueOf(caseone[4]);





        }







        return answer;
    }
}
