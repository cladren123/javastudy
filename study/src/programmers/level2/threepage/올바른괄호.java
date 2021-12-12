package programmers.level2.threepage;

import java.util.*;


public class 올바른괄호 {

    public static void main(String[] args) {
        String s1 = "()()";
        String s2 = "(())()";
        String s3 = ")()(";
        String s4 = "(()(";

        System.out.println(solution(s1));
        System.out.println(solution(s2));
        System.out.println(solution(s3));
        System.out.println(solution(s4));
    }

    static boolean solution(String s) {
        boolean answer = false;

        int n = s.length();

        Stack<Character> store = new Stack<>();

        for(int i = 0; i < n; i++)
        {
            if(store.size() == 0 && s.charAt(i) == ')')
                return false;

            if(s.charAt(i) == '(')
                store.push('(');
            else
                store.pop();
        }

        if(store.size() == 0)
            answer = true;


        return answer;
    }


}
