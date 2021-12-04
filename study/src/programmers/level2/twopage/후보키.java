package programmers.level2.twopage;

import java.util.*;
import java.lang.*;
import java.io.*;

public class 후보키 {

    public static void main(String[] args) {

        String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},
                {"400","con","computer","4"},{"500","muzi","music","3"}, {"600","apeach","music","2"}};

        System.out.println(solution(relation));

    }

    // 문제풀이
    // 후보키 후보 조합
    // 후보키 확인
    // 후보키가 된 게 있으면 후보키 후보에서 제외한다.

    static int answer; // 정답
    static int row; // 행, 세로
    static int col; // 열, 가로
    static int n; // 후보키의 개수
    static int m; // 추릴 후보키의 개수
    static int[] visited; // 탐색의 중복 여부 확인
    static int[] store; // 후보키 조합 저장

    static ArrayList<String> hubostore = new ArrayList<>();




    public static int solution(String[][] relation) {
        answer = 0;
        row = relation.length;
        col = relation[0].length;
        n = col;

        visited = new int[n];
        Arrays.fill(visited, 0);


        for(int i = 1; i <= col; i++)
        {
            m = i;

            store = new int[i];
            Arrays.fill(store, 0);

            dfs(0, relation);
        }


        return answer;
    }

    // 후보키 조합
    public static void dfs(int stage, String[][] relation)
    {

        if(stage == m)
        {
            System.out.println(Arrays.toString(store));

            HashMap<String,Integer> map = new HashMap<String, Integer>();


            int flag = 1;

            // 가로
            for(int i = 0; i < row; i++)
            {
                String index = "";
                // 세로
                for(int j = 0; j < m; j++)
                {
                    index += relation[i][store[j]];
                }

                if(map.containsKey(index))
                {
                    flag = 0;
                    break;
                }
                else
                {
                    map.put(index, 0);
                }
            }

            if(flag == 1)
            {
                answer += 1;
            }
            return;
        }

        for(int i = 0; i < n; i++)
        {
            if(visited[i] == 0)
            {
                if(stage > 0 && store[stage - 1] > i) continue;
                visited[i] = 1;
                store[stage] =  i;
                dfs(stage + 1, relation);
                visited[i] = 0;
            }
        }
    }
}
