package baekjoon.nandm;


import java.util.*;
import java.lang.*;
import java.io.*;


// 백준 15663 N과 M (9)

public class NO15663 {

    static int n,m;
    static int[] card;
    static int[] store;
    static int[] visited;

    // 중복제거용용
    static HashSet<String> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void dfs15663(int stage)
    {
        if(stage == m)
        {
            StringBuilder sb2 = new StringBuilder();
            for(int i = 0; i < m; i++)
            {
                sb2.append(store[i] + " ");
            }
            // set에 없으면 담고 set에 있으면 담지 않는 방식으로 중복 제거
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
            if(visited[i] == 0)
            {
                visited[i] = 1;
                store[stage] = card[i];
                dfs15663(stage+1);
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
        store = new int[m];
        visited = new int[n];
        Arrays.fill(visited, 0);


        dfs15663(0);
        System.out.print(sb);

    }
}
