package programmers.level2.onepage;

import java.util.*;
import java.lang.*;
import java.io.*;

/*
레전드 문제

조건을 걸 때  나와 상대방을 잘 설정해야 한다.
시간을 줄이기 위해 HashMap을 사용해야 한다.
탐색하는 부분이 있으면 무조건 HashMap으로 교체하자

 */

public class 단체사진찍기 {

    static int answer = 0;
    static char[] character = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};

    static char[] store = new char[8];
    static int[] visited = new int[8];

    static HashMap<Character, Integer> map = new HashMap<>();


    public static void main(String[] args) {

        int n1 = 2;
        String[] data1 = {"N~F=0", "R~T>2"};

        int n2 = 2;
        String[] data2 = {"M~C<2", "C~M>1"};

        System.out.println(solution(n1, data1));
        System.out.println(solution(n2, data2));


    }

    public static void dfs(int stage, int n, String[] data)
    {

        // 종단조건
        if(stage == 8)
        {
            int check = 1;

            // data의 조건
            for(int i = 0; i < n; i++)
            {
                String caseone = data[i];

                char first = caseone.charAt(0);
                char second = caseone.charAt(2);
                char giho = caseone.charAt(3);

                // 설정거리
                int guri = (int)(caseone.charAt(4) - '0' + 1);

                int start = map.get(first);
                int end = map.get(second);

                // for(int j = 0; j < 8; j++)
                // {
                //     if(store[j] == first) start = j;
                //     if(store[j] == second) end = j;
                // }

                // 거리
                int differ = Math.abs(start - end)  ;

                // differ : 사람들의 거리
                // guri : 설정한 거리

                if(giho == '<') {
                    if(differ >= guri) check = 0;

                }
                else if(giho == '='){
                    if(differ != guri){
                        check = 0;
                    }
                }
                else if(giho == '>') {
                    if(differ <= guri) check = 0;
                }
            }

            if(check == 1) answer += 1;
            return;
        }

        for(int i = 0; i < 8; i++)
        {
            if(visited[i] == 0)
            {
                visited[i] = 1;
                store[stage] = character[i];
                map.put(character[i], stage);
                dfs(stage+1, n, data);
                visited[i] = 0;
            }

        }

    }

    public static int solution(int n, String[] data) {
        answer = 0;

        // 시간을 줄이기 위한 맵
        for(int i = 0; i < 8; i++)
            map.put(character[i], i);


        // n : 조건의 개수
        // data : 조건의 모음

        // 제시한 사람, ~, 조건 대상, 범위, 크기

        Arrays.fill(store, 'a');
        Arrays.fill(visited, 0);

        dfs(0, n, data);


        return answer;
    }



}
