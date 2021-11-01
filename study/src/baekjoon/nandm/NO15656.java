package baekjoon.nandm;

import java.util.*;
import java.lang.*;
import java.io.*;

// 백준 15656N과 M (7)
// 중복가능
// StringBuilder를 사용하니 시간초과를 피할 수 있었다.

public class NO15656 {

    static int n,m;
    static int[] card;
    static int[] store;
    static StringBuilder sb = new StringBuilder();

    public static void dfs15656(int stage)
    {
        if(stage == m)
        {
            for(int i = 0; i < m; i++)
            {
                sb.append(store[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < n; i++)
        {
            store[stage] = card[i];
            dfs15656(stage+1);
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

        dfs15656(0);
        System.out.print(sb);

    }
}
