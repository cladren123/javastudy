package programmers.level3.page3;

import java.util.*;

public class 줄서는방법 {

    public static void main(String[] args) {
        int n = 3;
        int k = 5;

        System.out.println(Arrays.toString(solution(n,k)));
    }

    static int n;
    static long k;
    static ArrayList<Integer> list;
    static long fact[];
    static long fa;


    // dp형식으로 fact 계산
    static void init(int num)
    {
        fact[1] = 1;
        fact[2] = 2;

        for(int i = 3; i <= num; i++)
        {
            fact[i] = i * fact[i-1];
        }
    }


    public static int[] solution(int n, long k) {
        int[] answer = {};

        answer = new int[n];
        fact = new long[n+1];
        list = new ArrayList<>();

        for(int i = 1; i <= n; i++)
            list.add(i);

        init(n);

        long start = k-1;

        for(int i = 1; i < n; i++)
        {
            int idx = (int) (start / fact[n-i]);
            answer[i-1] = list.get(idx);
            list.remove(idx);
            start %= (fact[n-i]);
        }

        answer[n-1] = list.get(0);



        return answer;
    }

}
