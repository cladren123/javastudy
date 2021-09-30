package baekjoon.bfs;

import java.util.*;
import java.lang.*;
import java.io.*;

public class no1260second {

    // static 메모리에 할당. 프로그램 종료시까지 있는다.
    static int n,m,v;
    static int graph[][];
    static int visited1[];
    static int visited2[];
    

    public static void dfs2(int node){
        visited1[node] = 1;
        System.out.print(node + " ");
        for(int i = 1; i < n+1; i++){
            if(graph[node][i] == 1 && visited1[i] == 0){
                dfs2(i);
            }
        }
    }

    public static void bfs2(int node) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(node);
        visited2[node] = 1;

        while(!q.isEmpty()){
            int now = q.poll();

            System.out.print(now + " ");

            for(int k = 1; k < n+1; k++){
                if(graph[now][k] == 1 && visited2[k] == 0){
                    visited2[k] = 1;
                    q.offer(k);
                }
            }
        }
    }


    public static void main(String[] args) throws IOException{
        // 입력단
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        graph = new int[n+1][n+1];
        visited1 = new int[n+1];
        visited2 = new int[n+1];

        for(int i = 0; i < n+1; i++){
            Arrays.fill(graph[i], 0);
        }

        for(int i = 0; i < m; i++){
            String line = br.readLine();
            StringTokenizer one = new StringTokenizer(line, " ");
            int start = Integer.parseInt(one.nextToken());
            int end = Integer.parseInt(one.nextToken());
            graph[start][end] = 1;
            graph[end][start] = 1;
        }

//        for(int i = 0; i < n+1; i++){
//            for(int j = 0; j < n+1; j++){
//                System.out.print(graph[i][j]);
//            }
//            System.out.println();
//        }

        Arrays.fill(visited1, 0);
        Arrays.fill(visited2, 0);

        dfs2(v);
        System.out.println();
        bfs2(v);
    }
}
