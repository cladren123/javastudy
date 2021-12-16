package programmers.level2.twopage;

import java.util.*;
import java.lang.*;
import java.io.*;

public class 순위검색 {

    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

        System.out.println((solution(info, query)));
    }

    // 모든 경우의 수를 담을 map
    static HashMap<String, ArrayList<Integer>> map;


    public static ArrayList<Integer> solution(String[] info, String[] query) {
        ArrayList<Integer> answer = new ArrayList<>();

        map = new HashMap<>();
        int ninfo = info.length;

        // 모든 경우의 수를 구하기
        for(int i = 0; i < ninfo; i++)
        {
            dfs(0, "", info[i]);
        }

        int nquery = query.length;

        for(int i = 0; i < nquery; i++)
        {
            int result = 0;
            String[] one = query[i].split(" ");
            String caseone = one[0] + one[2] + one[4] + one[6];
            int score = Integer.parseInt(one[7]);
            // 이분 탐색

            System.out.println(caseone);
            answer.add(bsearch(caseone,score));

        }

        return answer;
    }


    // 모든 경우의 수 조합하는 함수
    public static void dfs(int stage, String store, String oneinfo)
    {
        String[] sp = oneinfo.split(" ");
        int score = Integer.parseInt(sp[4]);

        // 종단조건
        if(stage == 4)
        {
            // 있는 경우
            if(map.containsKey(store))
            {
                map.get(store).add(score);
            }
            // 없는 경우
            else
            {
                ArrayList<Integer> ione = new ArrayList<Integer>();
                ione.add(score);
                map.put(store, ione);
            }

            return;
        }

        dfs(stage+1, store + "-", oneinfo);
        dfs(stage+1, store + sp[stage], oneinfo);

    }


    // 이분탐색
    public static int bsearch(String caseone, int score)
    {
        int result = 0;

        // 찾는 대상이 map에 없다면 0을 리턴
        if(!map.containsKey(caseone)) return 0;

        ArrayList<Integer> one = map.get(caseone);
        Collections.sort(one);

        int start = 0;
        int end = one.size() - 1;

        while(start <= end)
        {
            int mid = (start + end) / 2;

            if(score > one.get(mid)) start = mid + 1;
            else end = mid - 1;
        }


        return one.size() - start;
    }

}
