package studyGroup.may.may22;

import java.util.*;
import java.io.*;

/*

w <= p 이기 때문에
t-n일 째 되는 날부터 수확하자.

 */

public class 당근훔쳐먹기18234 {

    static int n; // 당근의 종류 수
    static int t; // 재배할 예정 일 수
    static long[] w; // 당근의 처음 맛
    static long[] p; //  당근의 맛을 올려준 영양제

    static long[] board; // 당근밭

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        w = new long[n];
        p = new long[n];

        for(int i = 0; i < n; i++)
        {
            st = new StringTokenizer(br.readLine());

            w[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        int answr = 0;




























    }



}
