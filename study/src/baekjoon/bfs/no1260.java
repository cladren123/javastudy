package baekjoon.bfs;

// 백준 1260 DFS와 BFS

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class no1260 {

    // 변수 선언
    static int graph[][];
    static int visited[];
    static int n,m,v;

    // dfs 구현
    public static void dfs(int node){
        visited[node] = 1;
        System.out.print(node + " ");
        for(int i = 1; i < n+1; i++){
            if(graph[node][i] == 1 && visited[i] == 0){
                dfs(i);
            }
        }
    }

    // bfs 구현
    public static void bfs(int node){
        //
        Queue<Integer> q = new LinkedList<Integer>();
        //
        q.offer(node);
        visited[node] = 1;

        while(!q.isEmpty()){
            int now = q.poll();

            System.out.print(now+" ");

            for(int k = 1; k <= n; k++) {
                if(graph[now][k] == 1 && visited[k] == 0){
                    visited[k] = 1;
                    q.offer(k);
                }
            }
        }
    }



    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        // 배열 크기 정하기
        graph = new int[n+1][n+1];
        visited = new int[n+1];

        // 배열을 채우는 함수
        for(int i = 0; i < n+1; i++){
            Arrays.fill(graph[i], 0 );
        }

        Arrays.fill(visited, 0);

        // 배열을 출력하는 법
        // System.out.println(Arrays.toString(visited));

        for(int i = 0; i < m; i++){
            String edge = br.readLine();
            StringTokenizer st1 = new StringTokenizer(edge, " ");
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        dfs(v);
        System.out.println();
        Arrays.fill(visited, 0);
        bfs(v);

    }
}
