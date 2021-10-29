package baekjoon.sort;

import java.util.*;
import java.lang.*;
import java.io.*;

// 백준 1037번 약수

public class NO1037 {

    static int n;
    static int[] nl;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        nl = new int[n];

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");

        for(int i = 0; i < n; i++){
            nl[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nl);

        System.out.print(nl[0] * nl[n-1]);

    }
}
