package baekjoon.dfs;

import java.lang.*;
import java.io.*;
import java.util.*;

public class NO2606 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n : 컴퓨터의 수
        int n = Integer.parseInt(br.readLine());

        // m : 네트워크 상에 연결되 컴퓨터 쌍의 수
        int m = Integer.parseInt(br.readLine());

        // 관계를 저장할 2차원 배열
        int[][] graph  = new int[n+1][n+1];

        // 탐색할 때 중복 방문을 방지하기 위한 배열
        int[] visited = new int[n+1];

        // 배열들 초기화
        for(int i = 0; i < n+1; i++){
            Arrays.fill(graph[i], 0);
        }
        Arrays.fill(visited, 0);

        // 컴퓨터 연결
        for(int i = 0; i < m; i++){
            int n1,n2;
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s, " ");
            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());

            graph[n1][n2] = 1;
            graph[n2][n1] = 1;
        }

        // 감염된 컴퓨터를 센다.
        int count = 0;

        // 탐색을 위한 큐
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(1);
        visited[1] = 1;

        // 탐색
        while(!q.isEmpty()) {
            int now = q.poll();

            for(int i = 0; i < n+1; i++) {
                // 그래프에 연결되고 방문하지 않았으면 큐에 추가하고 count +1
                if(graph[now][i]==1 && visited[i] == 0){
                    visited[i] = 1;
                    count += 1;
                    q.offer(i);
                }
            }
        }

        // 정답 출력
        System.out.println(count);


    }
}
