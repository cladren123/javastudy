package programmers.level2.onepage;

import java.util.*;
import java.lang.*;
import java.io.*;

public class 괄호변환 {

    static String answer;

    public static void main(String[] args) {
        String p1 = "(()())()";
        String p2 = ")(";
        String p3 = "()))((()";

        System.out.println(solution(p1));
        System.out.println(solution(p2));
        System.out.println(solution(p3));

    }

    public static String solution(String p) {
        answer = "";
        answer += dfs(p);
        return answer;
    }

    public static String dfs(String p)
    {
        if(p == "") return "";

        int np = p.length();

        // 왼쪽 괄호, 오른쪽 괄호 카운팅
        int lnum = 0;
        int rnum = 0;

        String u = "";
        String v = "";

        // u랑 v랑 분리
        for(int ip = 0; ip < np; ip++)
        {
            if(p.charAt(ip) == '(') lnum += 1;
            if(p.charAt(ip) == ')') rnum += 1;

            // 균형잡힌 괄호 문자열
            if(lnum == rnum)
            {
                u = p.substring(0, ip + 1);
                v = p.substring(ip+1, np);
                break;
            }
        }

        Stack<Character> checker = new Stack<Character>();

        int un = u.length();


        // 올바른 괄호 문자열인지 확인
        for(int ui = 0; ui < un; ui++)
        {

            if(checker.size() == 0) checker.add(u.charAt(ui));
            else if(checker.size() >= 1)
            {
                Character lastone = checker.pop();
                if(lastone == '(' && u.charAt(ui) == ')') continue;
                else
                {
                    checker.add(lastone);
                    checker.add(u.charAt(ui));
                }

            }

        }

        // 올바른 괄호 문자열이 아닐 때
        String comp = "";

        // 올바른 괄호 문자열일 때 u를 추가한다.
        if(checker.size() == 0)
        {
            comp += u;
            comp += dfs(v);
            return comp;
        }

        else
        {
            comp += '(';
            comp += dfs(v);
            comp += ')';

            String miniu = u.substring(1, un-1);

            for(int miniui = 0; miniui < miniu.length(); miniui++)
            {
                if(miniu.charAt(miniui) == '(') comp += ')';
                else if(miniu.charAt(miniui) == ')') comp += '(';
            }

            return comp;

        }
    }


}
