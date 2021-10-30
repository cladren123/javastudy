package baekjoon.string;

import java.util.*;
import java.lang.*;
import java.io.*;

public class NO17413 {

    static StringBuilder sb = new StringBuilder();
    static Stack<Character> stk = new Stack<>();

    // 백준 17413 단어 뒤집기 2

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();



        // <> 안인지 밖인지 구분
        boolean inout = false;



        for(int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '<') {
                inout = true;
                while (!stk.isEmpty()) {
                    sb.append(stk.pop());
                }
                // < 기호 표시시
                sb.append(s.charAt(i));
            } else if (s.charAt(i) == '>') {
                inout = false;
                sb.append(s.charAt(i));
            } else if (inout) {
                sb.append(s.charAt(i));
            } else if (!inout) {
                if (s.charAt(i) == ' ') {


                    while (!stk.isEmpty()) {
                        sb.append(stk.pop());
                    }
                    sb.append(s.charAt(i));
                } else {
                    stk.push(s.charAt(i));

                }
            }
        }

        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }

        System.out.print(sb);
    }
}
