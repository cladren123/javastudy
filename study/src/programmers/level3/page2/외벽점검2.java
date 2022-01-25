package programmers.level3.page2;

import java.util.*;

public class 외벽점검2 {

    public static void main(String[] args) {
        int n = 12;
        int[] weak = {1,5,6,10};
        int[] dist = {1,2,3,4};

        System.out.println(solution(n, weak, dist));
    }

    static int n;
    static int[] weak;
    static int[] dist;
    static int[][] weakrotate;
    static int[] distperson;
    static boolean[] visited;
    static int answer;

    public static int solution(int n1, int[] weak1, int[] dist1) {

        n = n1;
        weak = weak1;
        dist = dist1;

        weakrotate = new int[weak.length][weak.length];
        answer = Integer.MAX_VALUE;


        rotate();

        // for(int i = 0; i < weak.length; i++)
        //     System.out.println(Arrays.toString(weakrotate[i]));


        for(int i = 1; i <= dist.length; i++)
        {
            visited = new boolean[dist.length];
            distperson = new int[i];
            person(0, i);
        }

        answer = answer == Integer.MAX_VALUE ? -1 : answer;

        return answer;

    }

    // weak 취약점의 시작지점을 rotate하게 해주는 함수
    public static void rotate()
    {
        for(int i = 0; i < weak.length; i++)
        {
            int[] rotateone = new int[weak.length];
            int index = i;

            for(int j = 0; j < weak.length; j++)
            {
                rotateone[j] = weak[index % weak.length];

                if(index >= weak.length)
                    rotateone[j] += n;

                index++;
            }

            weakrotate[i] = rotateone;
        }
    }
    // rotate()

    // 사람을 추리는 함수
    public static void person(int count, int pnumber)
    {
        // 종단조건 : 사람수만큼 추렸을 때
        if(count ==  pnumber)
        {
            // System.out.println(Arrays.toString(distperson));
            check();
            return;
        }

        for(int i = 0; i < dist.length; i++)
        {
            if(visited[i] == false)
            {
                visited[i] = true;
                distperson[count] = dist[i];
                person(count + 1, pnumber);
                visited[i] = false;
            }
        }
    }
    // 사람을 추리는 함수

    // 추린 사람들이 취약 지점을 다 커버할 수 있는지 확인하는 함수
    public static void check()
    {



        for(int i = 0; i < weakrotate.length; i++)
        {

            int index = 0; // weakrotate의 인덱스
            int start = weakrotate[i][index];

            for(int j = 0; j < distperson.length; j++)
            {

                while(index < weakrotate.length && weakrotate[i][index] - start <= distperson[j])
                {
                    index++;
                }
                // 다 커버할 수 있을 때
                if(index >= weakrotate.length)
                {
                    answer = Math.min(answer, distperson.length);
                }
                else
                {
                    start = weakrotate[i][index];
                }

            }
        }
    }
    // 추린 사람들이 취약 지점을 다 커버할 수 있는지 확인하는 함수


}
