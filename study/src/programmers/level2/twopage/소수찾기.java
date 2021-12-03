package programmers.level2.twopage;

import java.util.*;
import java.lang.*;
import java.io.*;

public class 소수찾기 {


    // 경우의 수 탐색할 때 담을 배열
    static char[] store;

    // 중복제거
    static int[] visited;
    static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) {

        String numbers1 = "17";
        String numbers2 = "011";

        // 각자 실행하니 또 되네
        System.out.println(solution(numbers1));
        System.out.println(solution(numbers2));

    }

    public static int solution(String numbers) {
        int answer = 0;
        char[] charnum = numbers.toCharArray();
        int n = charnum.length;

        set = new HashSet<>();

        for(int i = 1; i <= n; i++)
        {
            visited = new int[n];
            Arrays.fill(visited, 0);
            store = new char[i];
            Arrays.fill(store, 'a');

            dfs(0, n, i, charnum);
        }

        for(Integer one : set)
            if(check(one)) {
                answer += 1;
            }

        return answer;
    }

    public static void dfs(int stage, int n, int m, char[] charnum)
    {
        // 종단조건
        if(stage == m)
        {
            String one = new String(store);
            int ck = Integer.parseInt(one);
            set.add(ck);

            return;
        }

        for(int i = 0; i < n; i++)
        {
            if(visited[i] == 0)
            {
                visited[i] = 1;
                store[stage] = charnum[i];
                dfs(stage+1, n,m,charnum);
                visited[i] = 0;
            }
        }

    }

    // 소수를 확인하는 함수
    public static boolean check(int sosu)
    {
        boolean result = false;
        int count = 0;

        if(sosu == 1) return result;


        for(int i = 1; i <= (int)Math.sqrt(sosu); i++)
        {
            if(sosu % i == 0){
                count += 1;
            }
        }

        // 소수면 1을 반환 아니면 0을 반환
        if(count == 1) result = true;

        return result;
    }

}
