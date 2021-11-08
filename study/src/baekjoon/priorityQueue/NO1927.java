package baekjoon.priorityQueue;

import java.util.*;
import java.lang.*;
import java.io.*;

// 백준 1927 최소 힙

public class NO1927 {



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        PriorityQueue<Integer> pque = new PriorityQueue<>();

        int n = scan.nextInt();

        for(int i = 0; i < n; i++)
        {
            int m = scan.nextInt();

            if(m == 0)
            {
                if(pque.isEmpty()) System.out.println(0);
                else System.out.println(pque.poll());
            }
            else
            {
                pque.offer(m);
            }
        }

    }

}
