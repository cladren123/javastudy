package programmers.level2.page1;

import java.util.*;
import java.lang.*;

public class 메뉴리뉴얼 {

    // 조합을 만든 배열
    static char[] store;

    // 만들 숫자
    static int m;

    // 재료의 수
    static int n;

    // 재료의 종류
    static String card;

    // 중복 여부 판단
    static int[] visited;

    // 배열을 저장하는 해쉬맵
    static HashMap<String,Integer> map;


    public static void main(String[] args) {

        String[] orders1 = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course1 = {2,3,4};

        String[] orders2 = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course2 = {2,3,5};

        String[] orders3 = {"XYZ", "XWY", "WXA"};
        int[] course3 = {2,3,4};

        System.out.println(Arrays.toString(solution(orders1, course1)));
        System.out.println(Arrays.toString(solution(orders2, course2)));
        System.out.println(Arrays.toString(solution(orders3, course3)));
    }

    public static void dfs(int stage)
    {

        // 종단조건
        if(stage == m)
        {
            Arrays.sort(store);
            String caseone = new String(store);

            if(map.containsKey(caseone)) map.put(caseone, map.get(caseone) + 1);
            else map.put(caseone, 1);

            return;
        }

        for(int i = 0; i < n; i++)
        {
            if(visited[i] == 0)
            {
                if(stage > 0 && store[stage-1] > card.charAt(i)) continue;
                visited[i] = 1;
                store[stage] = card.charAt(i);
                dfs(stage + 1);
                visited[i] = 0;
            }
        }

    }

    public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        int ordersnum = orders.length;
        int coursenum = course.length;

        // 정답을 담을 리스트
        ArrayList<String> answerstore = new ArrayList<String>();


        for(int i = 0; i < coursenum; i++)
        {
            m = course[i];

            // 맵 초기화
            map = new HashMap<String, Integer>();

            for(int j = 0; j < ordersnum; j++)
            {
                n = orders[j].length();
                card = "" + orders[j];

                store = new char[m];
                Arrays.fill(store, 'a');

                visited = new int[n];
                Arrays.fill(visited, 0);

                if(m > n) continue;

                dfs(0);
            }

            int maxnum = 1;



            // 최대값 찾기
            for(String key : map.keySet())
            {
                if(map.get(key) > 1)
                    maxnum = Math.max(maxnum, map.get(key));
            }


            for(String key : map.keySet())
            {
                if(maxnum > 1 && map.get(key) == maxnum){
                    answerstore.add(key);
                }
            }

        }

        int an = answerstore.size();
        answer = new String[an];

        for(int i = 0; i < an ; i++)
        {
            answer[i] = answerstore.get(i);
        }

        Arrays.sort(answer);

        return answer;
    }
}
