package baekjoon.greedy;

import java.util.*;
import java.lang.*;
import java.io.*;

// 백준 1715 카드 정렬하기

public class NO1715 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] card = new int[n];

        for(int i = 0; i < n; i++)
        {
            card[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(card);

        // 우선순위 큐 활용
        PriorityQueue<Integer> pque = new PriorityQueue<>();
        for(int i = 0; i < n; i++)
        {
            pque.offer(card[i]);
        }

        ArrayList<Integer> alist = new ArrayList<Integer>();

        while(pque.size() != 1)
        {
            int a = pque.poll();
            int b = pque.poll();
            int com = a + b;
            pque.offer(com);
            alist.add(com);
        }

        int answer = 0;

        while(!alist.isEmpty())
        {
            answer += alist.remove(0);
        }

        System.out.print(answer);


    }
}
