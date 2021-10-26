package baekjoon.nandm;

import java.util.*;
import java.lang.*;
import java.io.*;

// 15650 N과 M (2)

public class NO15650 {

    static int n,m;
    static int[] visited;
    static int[] store;

    public static void dfs15650(int stage) {

        // 종단조건
        if(stage == m){
            for(int i = 0; i < m; i++){
                System.out.print(store[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int j = 0; j < n; j++){
            if(visited[j] == 0) {
                if(stage > 0 && store[stage-1] > j+1) continue;
                else {
                    visited[j] = 1;
                    store[stage] = j+1;
                    dfs15650(stage+1);
                    visited[j] = 0;
                }
            }
        }


        /*
        1안
        for(int j = 0; j < n; j++){
            if(visited[j] == 0){
                if(stage == 0) {
                    visited[j] = 1;
                    store[stage] = j+1;
                    dfs15650(stage+1);
                    visited[j] = 0;
                }
                else if(stage >= 1 && store[stage-1] < j+1){
                    visited[j] = 1;
                    store[stage] = j+1;
                    dfs15650(stage+1);
                    visited[j] = 0;
                }
            }
        }
        */




    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new int[n];
        Arrays.fill(visited, 0);
        store = new int[m];
        Arrays.fill(store, 0);

        dfs15650(0);

    }
}
