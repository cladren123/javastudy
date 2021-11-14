package programmers.level1;

import java.util.*;
import java.lang.*;
import java.io.*;


public class 소수만들기 {

    static int[] card;
    static int n;
    static int[] visited;
    static int answer;
    static int[] store;

    public static void main(String[] args) {

        int[] nums1 = {1,2,3,4};
        int[] nums2 = {1,2,7,6,4};

        System.out.println(solution(nums1));
        System.out.println(solution(nums2));
    }

    public static void dfs(int stage)
    {
        if(stage == 3)
        {
            int number = 0;
            for(int i = 0; i < 3; i++)
            {
                number += store[i];
            }
            int check = 0;
            int sq = (int)Math.sqrt(number) + 1;
            for(int i = 2; i < sq; i++)
            {
                if(number % i == 00) check += 1;
            }

            if(check == 0) answer += 1;


            // 소수를 확인하는 함수
            return;
        }

        for(int i = 0; i < n; i++)
        {
            if(visited[i] == 0)
            {
                if(stage > 0 && store[stage-1] > card[i]) continue;
                visited[i] = 1;
                store[stage] = card[i];
                dfs(stage+1);
                visited[i] = 0;
            }
        }

    }

    public static int solution(int[] nums) {
        answer = 0;

        card = nums;
        n = nums.length;

        visited = new int[n];
        Arrays.fill(visited, 0);

        store = new int[3];
        Arrays.fill(store, 0);

        dfs(0);

        return answer;
    }
}
