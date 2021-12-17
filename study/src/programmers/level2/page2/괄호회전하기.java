package programmers.level2.page2;

import java.util.*;
import java.lang.*;
import java.io.*;

public class 괄호회전하기 {

    public static void main(String[] args) {

        String s1 = "[](){}";
        String s2 = "}]()[{";
        String s3 = "[)(]";
        String s4 = "}}}";

        System.out.println(solution(s1));
        System.out.println(solution(s2));
        System.out.println(solution(s3));
        System.out.println(solution(s4));
    }

    public static int solution(String s) {
        int answer = 0;

        int ns = s.length();

        // 왼쪽으로 이동
        for(int i = 0; i < ns; i++)
        {
            char one = s.charAt(0);
            String news = s.substring(1,ns);
            news += one;
            if(checker(news) == 1) answer += 1;
            s = news;
        }

        return answer;
    }

    // 0 : 올바르지 않음, 1 : 올바름
    public static int checker(String s)
    {
        int result = 1;

        int ns = s.length();

        Stack<Character> store = new Stack<>();

        for(int i = 0; i < ns; i++)
        {
            if(store.size() == 0)
                store.push(s.charAt(i));
            else if(store.size() > 0)
            {
                char one = store.pop();
                if(one == '[' && s.charAt(i) == ']')
                    continue;
                else if(one == '(' && s.charAt(i) == ')')
                    continue;
                else if(one == '{' && s.charAt(i) == '}')
                    continue;
                else
                {
                    store.push(one);
                    store.push(s.charAt(i));
                }

            }
        }

        if(store.size() != 0) result = 0;



        return result;
    }

}
