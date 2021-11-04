package baekjoon.nandm;

import java.util.*;
import java.lang.*;
import java.io.*;

// 백준 15665 N과 M (11)

public class NO15665 {

    static int n,m;
    static int[] card;
    static int[] store;
    static StringBuilder sb = new StringBuilder();
    static HashSet<String> set = new HashSet<>();

    public static void dfs15665(int stage)
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
                sb.append('\n');
                set.add(sb2.toString());
            }
            return;
        }

        for(int i = 0; i < n; i++)
        {
            store[stage] = card[i];
            dfs15665(stage+1);
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

        store = new int[m];

        dfs15665(0);
        System.out.print(sb);

    }
}
