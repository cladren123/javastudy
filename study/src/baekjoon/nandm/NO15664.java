package baekjoon.nandm;

import java.util.*;
import java.lang.*;
import java.io.*;


// N과 M (10)

public class NO15664 {

    static int n,m;
    static int[] card;
    static int[] visited;
    static int[] store;

    static StringBuilder sb = new StringBuilder();
    static HashSet<String> set = new HashSet<>();


    public static void dfs15664(int stage)
    {
        if(stage == m)
        {
            StringBuilder sb2 = new StringBuilder();
            for(int i = 0; i < m; i++)
            {
                sb2.append(store[i] + " ");
            }

            if(!set.contains(sb2.toString()))
            {
                sb.append(sb2.toString());
                sb.append("\n");
                set.add(sb2.toString());
            }
            return;
        }

        for(int i = 0; i < n; i++)
        {
            if(stage > 0 && store[stage-1] > card[i]) continue;
            if(visited[i] == 0)
            {
                visited[i] = 1;
                store[stage] = card[i];
                dfs15664(stage+1);
                visited[i] = 0;
            }

        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        m = scan.nextInt();

        card = new int[n];

        for(int i = 0; i < n; i++)
        {
            card[i] = scan.nextInt();
        }
        Arrays.sort(card);

        visited = new int[n];
        Arrays.fill(visited, 0);

        store = new int[m];
        Arrays.fill(store, 0);

        dfs15664(0);
        System.out.print(sb);

    }
}
