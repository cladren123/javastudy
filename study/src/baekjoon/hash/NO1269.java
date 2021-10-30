package baekjoon.hash;

import java.util.*;
import java.lang.*;
import java.io.*;

// 백준 1269 대칭 차집합

public class NO1269 {

    static int a,b;
    static int a1,b1;
    static HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
    static HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        s = br.readLine();
        st = new StringTokenizer(s, " ");

        for(int i = 0; i < a; i++){
            map1.put(Integer.parseInt(st.nextToken()), 1);
        }

        s = br.readLine();
        st = new StringTokenizer(s, " ");

        for(int i = 0; i < b; i++){
            map2.put(Integer.parseInt(st.nextToken()), 1);
        }


        a1 = 0;
        b1 = 0;

        for(Integer i : map1.keySet()) {
            if(!map2.containsKey(i)) {
                a1 += 1;
            }
        }

        for(Integer i : map2.keySet()){
            if(!map1.containsKey(i)){
                b1 += 1;
            }
        }

        System.out.printf("%d", a1+b1);










    }
}
