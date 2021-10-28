package baekjoon.nandm;


import java.util.*;
import java.lang.*;
import java.io.*;


// N과 M (3)
// N과 M 수열 중 같은 수를 여러번 골라도 된다.

public class NO15651 {

    static int n,m;
    static int[] store;
    static StringBuilder sb = new StringBuilder();

    public static void dfs15651(int stage){

        if(stage == m) {
            for(int i = 0; i < m; i++){
                // System.out을 사용하면 시간초과 발생, StringBuilder를 사용
                // System.out.print(store[i] + " ");
                sb.append(store[i] + " ");
            }
            sb.append('\n');
            return;
        }

        for(int j = 0; j < n; j++) {
            store[stage] = j+1;
            dfs15651(stage+1);
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

        dfs15651(0);
        System.out.print(sb);
    }
}