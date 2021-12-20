package programmers.level3.page2;

import java.util.*;

public class 단어변환 {

    public static void main(String[] args) {

        String begin1 = "hit";
        String target1 = "cog";
        String[] words1 = {"hot", "dot", "dog", "lot", "log", "cog"};

        String begin2 = "hit";
        String target2 = "cog";
        String[] words2 = {"hot", "dot", "dog", "lot", "log"};

        System.out.println(solution(begin1, target1, words1));
        System.out.println(solution(begin2, target2, words2));

    }

    public static int solution(String begin, String target, String[] words) {
        int answer = 60;

        // bfs를 활용해 보자

        int n = words.length;
        int m = begin.length();

        Queue<dot> que = new LinkedList<>();
        que.add(new dot(begin, 0));

        boolean[] visited = new boolean[n];

        while(!que.isEmpty())
        {
            dot d = que.poll();



            for(int i = 0; i < n; i++)
            {
                int check = 0;
                // 한 번도 방문한 적 없는 단어들을 대상으로 탐색
                if(visited[i] == false)
                {
                    // words[i]와 본래의 것을 비교한다.
                    for(int j = 0; j < m; j++)
                    {
                        if(words[i].charAt(j) == d.word.charAt(j))
                            check += 1;

                        if(check == m-1)
                        {
                            visited[i] = true;
                            if(words[i].equals(target) )
                            {
                                answer = Math.min(answer, d.count+1);
                            }

                            else
                                que.add(new dot(words[i], d.count+1));
                        }
                    }
                }
            }
        }

        if(answer == 60) answer = 0;


        return answer;
    }

    static class dot
    {
        String word;
        int count;

        dot(String word, int count)
        {
            this.word = word;
            this.count = count;
        }
    }

}
