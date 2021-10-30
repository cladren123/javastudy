package baekjoon.nandm;

import java.util.*;
import java.lang.*;
import java.io.*;

// N과 M (5)

public class NO15654 {

    static int n,m;
    static int[] card;
    static int[] store;
    static int[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void dfs15654(int stage){

        // 종단 조건
        if(stage == m){
            for(int i : store){
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < n; i++){
            if(visited[i] == 0) {
                visited[i] = 1;
                store[stage] = card[i];
                dfs15654(stage+1);
                visited[i] = 0;
            }
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
        for(int i = 0; i < n; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(card);

        store = new int[m];
        Arrays.fill(store, 0);

        visited = new int[n];
        Arrays.fill(visited, 0);

        dfs15654(0);
        System.out.print(sb);

    }
}
