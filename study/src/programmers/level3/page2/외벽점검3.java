package programmers.level3.page2;

import java.util.*;

public class 외벽점검3 {

    public static void main(String[] args) {

        int n = 12;
        int[] weak = {1,5,6,10};
        int[] dist = {1,2,3,4};

        System.out.println(solution(n,weak,dist));

    }

    static int n;
    static int[] weak;
    static int[] dist;
    static int answer;

    static int weakn;
    static int distn;

    static int[][] weakrotate;

    static int[] store;
    static boolean[] visited;

    public static int solution(int n1, int[] weak1, int[] dist1) {
        answer = Integer.MAX_VALUE;

        n = n1;
        weak = weak1;
        dist = dist1;

        weakn = weak.length;
        distn = dist.length;

        weakrotate = new int[weakn][weakn];

        rotate();

        // for(int i = 0; i < weakn; i++)
        //     System.out.println(Arrays.toString(weakrotate[i]));

        for(int i = 1; i <= distn; i++)
        {
            store = new int[i];
            visited = new boolean[distn];
            perdist(0, i);
        }

        answer = answer == Integer.MAX_VALUE ? -1 : answer;

        return answer;
    }

    // weak의 모든 시작점을 저장하는 rotate함수
    public static void rotate()
    {
        for(int i = 0; i < weakn; i++)
        {
            int[] weakone = new int[weakn];
            int index = i;

            for(int j = 0; j < weakn; j++)
            {
                weakone[j] = weak[index % weakn];
                index += 1;

                if(index > weakn) weakone[j] += n;
            }

            weakrotate[i] = weakone;
        }
    }
    // rotate 함수

    // 배치할 사람의 경우의 수를 구하는 함수
    public static void perdist(int count, int number)
    {
        if(count == number)
        {
            check();
            return;
        }

        for(int i = 0; i < distn; i++)
        {
            if(visited[i] == false)
            {
                visited[i] = true;
                store[count] = dist[i];
                perdist(count + 1, number);
                visited[i] = false;
            }
        }
    }
    // 배치할 사람의 경우의 수를 구하는 함수

    // 뽑힌 사람들이 취약지점들을 커버할 수 있는지 확인하는 check 함수
    // store : 뽑힌 사람들   weakrotate : 출발지점에 따른 취약지점모음
    public static void check()
    {
        for(int i = 0; i < weakn; i++)
        {

            int start = weakrotate[i][0];
            int index = 0;

            for(int j = 0; j < store.length; j++)
            {

                while(index < weakn && weakrotate[i][index]-start <= store[j])
                {
                    index += 1;
                }

                //
                if(weakn - index <= store.length - j - 1)
                {
                    answer = Math.min(answer, store.length);
                }
                else
                {
                    start = weakrotate[i][index];
                }
            }
        }
    }

    // check 함수


}
