package programmers.level2.page2;

import java.util.*;

public class 조이스틱 {


    public static void main(String[] args) {

        String name1 = "JEROEN";
        String name2 = "JAN";

        System.out.println(solution(name1));
        System.out.println(solution(name2));

    }

    public static int solution(String name) {
        int answer = 0;

        int n = name.length();

        // 알파벳 맞추기

        int cnum = 0;

        int[] visited = new int[n];
        Arrays.fill(visited, 0);

        for(int i = 0; i < n; i++)
        {
            int one = (int)(name.charAt(i) - 'A');
            int two = (int)('Z' - name.charAt(i)) + 1;

            answer += Math.min(one, two);

            if(i > 0 && name.charAt(i) != 'A'){
                cnum += 1;
                visited[i] = 1;
            }

        }

        // 조이스틱 무빙
        int index = 0;

        while(cnum != 0)
        {
            int right = index;
            int left = index;

            int count = 0;

            int flag = 1;

            while(flag == 1)
            {
                count += 1;
                right += 1;
                left -= 1;

                if(right >= n) right = 0;
                if(left < 0) left = n-1;

                if(visited[right] == 1)
                {
                    answer += count;
                    visited[right] = 0;
                    index = right;
                    cnum -= 1;
                    flag = 0;
                    break;
                }

                if(visited[left] == 1)
                {
                    answer += count;
                    visited[left] = 0;
                    index = left;
                    cnum -= 1;
                    flag = 0;
                    break;
                }
            }
        }






        return answer;
    }

}
