package baekjoon.bfs;

import java.util.*;
import java.lang.*;
import java.io.*;

public class no2178 {
    // n : 세로, m : 가로
    static int n, m;
    static int[][] board;
    static int[][] visited;

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line, " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new int[n][m];

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < m; j++){
                board[i][j] = str.charAt(j) - '0';
            }
        }

//        for(int i = 0; i < n; i++){
//            System.out.println(Arrays.toString(board[i]));
//        }

        for(int i = 0; i < n; i++) {
            Arrays.fill(visited[i], 0);
        }

        // 시작 설정
        visited[0][0] = 1;

        Queue<Dot> q = new LinkedList<Dot>();
        q.add(new Dot(0,0));

        while(!q.isEmpty()){
            Dot d = q.poll();

            for(int i = 0; i < 4; i++){
                int nextx = d.x + dx[i];
                int nexty = d.y + dy[i];

                if(nextx >= 0 && nextx < m && nexty >= 0 && nexty < n ){
                    if(visited[nexty][nextx] == 0 && board[nexty][nextx] != 0){
                        board[nexty][nextx] = board[d.y][d.x] + 1;
                        visited[nexty][nextx] = 1;
                        q.add(new Dot(nexty,nextx));
                    }
                }
            }
        }

        System.out.println(board[n-1][m-1]);

    }
}

// bfs에 돌리기 위해 클래스 선언
class Dot {
    int y;
    int x;

    Dot(int y, int x){
        this.y = y;
        this.x = x;
    }
}
