package baekjoon.nandm;

import java.util.*;
import java.lang.*;
import java.io.*;

// 15649 N과 M (1)

public class NO15649 {

    static int n,m;
    static int[] visited;
    static int[] store;


    public static void dfs15649(int stage) {

        // 종단조건
        if(stage == m){
            for(int j=0; j<m; j++){
                System.out.print(store[j] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=1; i <= n; i++){
            if(visited[i] == 0) {
                visited[i] = 1;
                store[stage] = i;
                dfs15649(stage+1);
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

        visited = new int[n+1];
        Arrays.fill(visited, 0);
        store = new int[m];
        Arrays.fill(store, 0);

        dfs15649(0);

    }
}
