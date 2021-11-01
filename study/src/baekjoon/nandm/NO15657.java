package baekjoon.nandm;

import java.util.*;
import java.lang.*;
import java.io.*;

// 백준 15657 N과 M (8)
// 중복가능, 비내림차순(내려갈 수록 증가)

public class NO15657 {

    static int n,m;
    static int[] card;
    static int[] store;
    static StringBuilder sb = new StringBuilder();

    public static void dfs15657(int stage)
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
            if(stage > 0 && store[stage-1] > card[i]) continue;
            store[stage] = card[i];
            dfs15657(stage+1);

        }

    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        s = br.readLine();
        st = new StringTokenizer(s, " ");

        card = new int[n];
        for(int i = 0; i < n; i++)
        {
            card[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(card);

        store = new int[m];

        dfs15657(0);
        System.out.print(sb);
    }
}
