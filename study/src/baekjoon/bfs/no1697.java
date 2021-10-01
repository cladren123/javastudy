package baekjoon.bfs;

// 1697 숨바꼭질

// import 3대장 유틸,랭,아이오
import java.util.*;
import java.lang.*;
import java.io.*;

public class no1697 {
    // n : 수빈, k : 동생생
    static int n, k;
    static int maxnum;
    static int[] board;


    public static void bfs1697(int node) {

        Queue<Integer> q = new LinkedList<Integer>();

        int[] status = new int[3];

        board[node] = 0;

        q.offer(node);

        // q가 비어있지 않으면 계속 돈다.
        while(!q.isEmpty()) {
            int now = q.poll();

            int n1 = now + 1;
            int n2 = now - 1;
            int n3 = now * 2;

            status[0] = n1;
            status[1] = n2;
            status[2] = n3;

            for(int i = 0; i < 3; i++){
                if(status[i] >= 0 && status[i] < maxnum && board[status[i]] == -1) {
                    board[status[i]] = board[now] +1;
                    q.offer(status[i]);
                }
            }
        }


        System.out.println(board[k]);


    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String line = br.readLine();

        StringTokenizer st = new StringTokenizer(line, " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        maxnum = 100001;

        board = new int[maxnum];
        Arrays.fill(board, -1);

        bfs1697(n);


    }
}
