package programmers.level3.page2;

import java.util.*;

public class 합승택시요금 {


    // n : 지점 개수
    // s : 출발 지점
    // a : A의 도착지점
    // b : B의 도착지점
    // fares : 택시요금

    public static void main(String[] args) {
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};

        System.out.println(solution(n,s,a,b,fares));


    }

    // n : 지점 개수
    // s : 출발 지점
    // a : A의 도착지점
    // b : B의 도착지점
    // fares : 택시요금

    static int n;
    static ArrayList<ArrayList<Dot>> board;

    public static int solution(int n1, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;

        n = n1;
        board = new ArrayList<>();

        for(int i = 0; i < n+1; i++)
            board.add(new ArrayList<>());

        for(int i = 0; i < fares.length; i++)
        {
            int st = fares[i][0];
            int en = fares[i][1];
            int mo = fares[i][2];

            board.get(st).add(new Dot(en, mo));
            board.get(en).add(new Dot(st, mo));
        }


        int[] startA = new int[n+1];
        int[] startB = new int[n+1];
        int[] start = new int[n+1];

        Arrays.fill(startA, Integer.MAX_VALUE);
        Arrays.fill(startB, Integer.MAX_VALUE);
        Arrays.fill(start, Integer.MAX_VALUE);

        for(int i = 1; i < n+1; i++)
        {
            startA = guri(a, startA);
            startB = guri(b, startB);
            start = guri(s, start);
        }

        for(int i = 1; i < n+1; i++)
        {
            answer = Math.min(answer, startA[i] + startB[i] + start[i]);
        }



        return answer;
    }


    // 지점간의 최소값을 구함
    public static int[] guri(int start, int[] mlist)
    {
        // 다익스트라 탐색
        PriorityQueue<Dot> que = new PriorityQueue<>();

        que.add(new Dot(start, 0));
        mlist[start] = 0;



        while(!que.isEmpty())
        {
            Dot d = que.poll();

            int spot = d.spot;
            int money = d.money;

            if(mlist[spot] < money) continue;

            ArrayList<Dot> darr = board.get(spot);
            for(Dot dot : darr)
            {
                int newmoney = money + dot.money;

                if(newmoney < mlist[dot.spot])
                {
                    mlist[dot.spot] = newmoney;
                    que.add(new Dot(dot.spot, newmoney));
                }
            }


        }


        return mlist;
    }

    // 출저 : https://wellbell.tistory.com/101
    static class Dot implements Comparable<Dot>
    {
        int spot;
        int money;

        Dot(int spot, int money)
        {
            this.spot = spot;
            this.money = money;
        }

        @Override
        public int compareTo(Dot e)
        {
            return this.money - e.money;
        }
    }
}
