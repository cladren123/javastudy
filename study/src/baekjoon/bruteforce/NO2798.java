package baekjoon.bruteforce;

import java.util.*;
import java.lang.*;
import java.io.*;


// 2798 블랙잭

public class NO2798 {
    // n : 카드의 개수, m : 목표값
    static int n,m;
    static int[] nlist;
    static int answer;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nlist = new int[n];
        Arrays.fill(nlist, 0);
        String s1 = br.readLine();
        StringTokenizer st1 = new StringTokenizer(s1, " ");

        for(int i = 0; i < n; i++){
            nlist[i] = Integer.parseInt(st1.nextToken());
        }

        for(int i = 0; i < n -2; i++){
            if(nlist[i] > m) continue;

            for(int j = i+1; j < n-1; j++){
                if((nlist[i] + nlist[j]) > m ) continue;

                for(int k = j+1; k < n; k++) {
                    if( (nlist[i] + nlist[j] + nlist[k]) > m) continue;
                    else {
                        result = nlist[i] + nlist[j] + nlist[k];
                        answer = Math.max(answer, result);
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
