package baekjoon.dfs;

import java.util.*;
import java.lang.*;
import java.io.*;

// 백준 2644 촌수계산

public class NO2644 {

    // n : 전체 사람의 수
    // t1, t2 : 촌수 계산 대상
    // m : 부모 자식들 간의 관계의 수
    static int n, t1, t2, m;
    static int i1, i2;


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        t1 = scan.nextInt();
        t2 = scan.nextInt();
        m = scan.nextInt();

        int[][] graph = new int[n+1][n+1];
        for(int i = 0; i < n+1; i++)
        {
            Arrays.fill(graph[i], 0);
        }

        for(int i = 0; i < m; i++)
        {
            // i1 : 부모 i2 : 자식
            i1 = scan.nextInt();
            i2 = scan.nextInt();
            graph[i1][i2] = 1;
            graph[i2][i1] = 1;
        }

        int[][] visited = new int[n+1][n+1];
        for(int i = 0; i < n+1; i++)
        {
            Arrays.fill(visited[i], 0);
        }

        Queue<Person> que = new LinkedList<>();
        que.offer(new Person(t1, 0));

        int answer = -1;

        int flag = 1;

        while(!que.isEmpty())
        {

            Person person = que.poll();
            int start = person.x;
            int count = person.count;

            for(int i = 1; i < n+1; i++)
            {
                if(visited[start][i] == 0 && graph[start][i] == 1)
                {
                    if(i == t2)
                    {
                        answer = count + 1;
                        flag = 0;
                        break;
                    }

                    visited[start][i] = 1;
                    que.offer(new Person(i, count+1));

                }
            }

            if(flag == 0)
            {
                break;
            }
        }

        System.out.print(answer);

    }

    public static class Person
    {
        int x;
        int count;

        public Person(int x, int count)
        {
            this.x = x;
            this.count = count;
        }
    }


}
