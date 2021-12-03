package programmers.level2.onepage;

import java.util.*;

public class 짝지어제거하기 {

    public static void main(String[] args) {
        String s1 = "baabaa";
        String s2 = "cdcd";

        System.out.println(solution(s1));
        System.out.println(solution(s2));

    }

    public static int solution(String s)
    {
        int answer = 0;

        int n = s.length();

        // 종단조건
        // 문자열이 전부 비거나, 더 이상 압축할 수가 없을 때

        // 스택을 활용하자.

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < n; i++)
        {
            if(stack.size() == 0)
            {
                stack.push(s.charAt(i));
            }
            else
            {
                char one = stack.pop();
                if(one == s.charAt(i))
                    continue;
                else
                {
                    stack.push(one);
                    stack.push(s.charAt(i));
                }
            }
        }

        if(stack.size() == 0) answer = 1;

        return answer;
    }

}
