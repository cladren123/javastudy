package programmers.level3.page1;

import java.util.*;

public class 네트워크 {

    public static void main(String[] args) {

        int n1 = 3;
        int[][] computers1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        int n2 = 3;
        int[][] computers2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};

        System.out.println(solution(n1, computers1));
        System.out.println(solution(n2, computers2));

    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;

        // 컴퓨터의 연결정보의 개수
        int comn = computers.length;

        // 탐색 여부를 확인
        // boolean을 사용하는게 int보다 이득
        int[] visited = new int[n];

        for(int i = 0; i < comn; i++)
        {
            computers[i][i] = 0;
        }

        Deque<Integer> que = new LinkedList<>();

        int count = 0;

        for(int i = 0; i < n; i++)
        {
            if(visited[i] != 0) continue;
            else if(visited[i] == 0)
            {
                count += 1;
                visited[i] = count;
                que.add(i);

                while(!que.isEmpty())
                {
                    int temp = que.poll();
                    for(int j = 0; j < n; j++)
                    {
                        if(computers[temp][j] == 1 && visited[j] == 0)
                        {
                            visited[j] = count;
                            que.add(j);
                        }
                    }
                }

            }
        }




        answer = count;



        return answer;
    }



}
