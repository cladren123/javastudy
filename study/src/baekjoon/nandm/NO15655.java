package baekjoon.nandm;

import java.util.*;
import java.lang.*;
import java.io.*;

// N과 M (6)

public class NO15655 {

    static int n,m;
    static int[] card;

    // 중복 바지일 때 사용
    static int[] visited;
    static int[] store;

    public static void dfs15655(int stage){

        if(stage == m){
            for(int i = 0; i < m; i++)
            {
                System.out.print(store[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i < n; i++)
        {
            // 중복 방지
            if(visited[i] == 0)
            {
                // 다음에 올 수가 앞에 수보다 작으면 생략
                if(stage > 0 && store[stage-1] > card[i]) continue;
                visited[i] = 1;
                store[stage] = card[i];
                dfs15655(stage+1);
                visited[i] = 0;
            }
        }
    }


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        m = scan.nextInt();

        card = new int[n];
        Arrays.fill(card, 0);

        for(int i = 0; i < n; i++) {
            card[i] = scan.nextInt();
        }

        Arrays.sort(card);

        visited = new int[n];
        Arrays.fill(visited, 0);

        store = new int[m];

        dfs15655(0);



    }

}
