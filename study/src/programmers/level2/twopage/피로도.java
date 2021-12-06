package programmers.level2.twopage;

import java.util.*;

public class 피로도 {

    // 완전 탐색
    static int n;
    static int m;
    static int[] visited;
    static int[] store;
    static int hp;
    static int answer;


    public static void main(String[] args) {

        int k = 80;
        int[][] dungeons = 	{{80,20},{50,40},{30,10}};

        System.out.println(solution(k, dungeons));

    }

    public static int solution(int k, int[][] dungeons) {
        answer = 0;

        n = dungeons.length;
        m = dungeons.length;

        visited = new int[m];
        Arrays.fill(visited, 0);

        store = new int[m];
        Arrays.fill(store, 0);

        hp = k;

        dfs(0, dungeons);

        return answer;
    }

    // 완전탐색
    public static void dfs(int stage, int[][] dungeons)
    {
        // 종단조건
        if(stage == m)
        {
            // 던전 탐색 순서
            // System.out.println(Arrays.toString(store));

            int hpone = hp;
            int count = 0;

            for(int i = 0; i < m; i++)
            {
                int piro = dungeons[store[i]][0];
                int minu = dungeons[store[i]][1];

                if(hpone < piro)
                    break;
                else
                {
                    count += 1;
                    hpone -= minu;
                }
            }

            answer = Math.max(answer, count);

            return;
        }

        for(int i = 0; i < n; i++)
        {
            if(visited[i] == 0)
            {
                visited[i] = 1;
                store[stage] = i;
                dfs(stage+1, dungeons);
                visited[i] = 0;
            }
        }

    }



}
