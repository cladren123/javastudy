package baekjoon.nandm;

import java.util.*;
import java.lang.*;
import java.io.*;

// N과 M (4)
// 비내림차순 수열

public class NO15652 {

    static int n,m;
    static int[] store;
    static StringBuilder sb = new StringBuilder();

    public static void dfs15652(int stage) {

        // 종단조건
        if(stage == m) {
            for(int i = 0; i < m; i++){
                sb.append(store[i] + " ");
            }
            sb.append("\n");
            return;
        }

        // 탐색
        for(int j = 0; j < n; j++) {
            // 현재 들어오려는 숫자가 이전 숫자보다 작으면 생략한다.
            if(stage > 0 && store[stage-1] > j+1) continue;
            store[stage] = j+1;
            dfs15652(stage+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        store = new int[m];
        Arrays.fill(store, 0);

        dfs15652(0);
        System.out.print(sb);

    }
}
