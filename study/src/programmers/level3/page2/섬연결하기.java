package programmers.level3.page2;

import java.util.*;

public class 섬연결하기 {

    static int[] parent;

    public static void main(String[] args) {
        int n = 4;
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};

        System.out.println(solution(n, costs));
    }

    public static int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        for(int i = 0; i < n; i++)
            parent[i] = i;

        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);

        int costsn = costs.length;

        for(int i = 0; i < costsn; i++)
        {
            int s = costs[i][0];
            int e = costs[i][1];

            // 부모가 다르면 연결해준다.
            if(find(s) != find(e))
            {
                answer += costs[i][2];
                union(s,e);
            }
        }
        return answer;
    }


    public static int find(int a)
    {
        if(parent[a] == a)
            return a;
        else
            return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b)
    {
        a = find(a);
        b = find(b);
        if(a != b)
            parent[b] = a;
    }
}
