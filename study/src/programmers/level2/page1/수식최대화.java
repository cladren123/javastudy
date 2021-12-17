package programmers.level2.page1;

import java.util.*;
import java.lang.*;

public class 수식최대화 {

    // 연산자 추출
    static List<Character> op;

    // 문자열 나누기
    static ArrayList<String> sp = new ArrayList<String>();

    // 저장소
    static char[] store;

    // 여부 확인
    static int[] visited;

    // 연산자의 개수
    static int m;

    // 정답
    static long answer;

    public static void main(String[] args) {

        String expression1 = "100-200*300-500+20";
        String expression2 = "50*6-3*2";

        // 독립적으로 시행되면 된다. 왜 이러지? 남아있나본데..
//        System.out.println(solution(expression1));

        System.out.println(solution(expression2));

    }



    public static long solution(String expression) {
        answer = 0;

        // 연산자의 우선 순위를 정함
        // 우선 순위를 정한 것을 바탕으로 수식을 풀어야 한다.

        int n = expression.length();

        int index = 0;

        HashSet<Character> operator = new HashSet<>();

        for(int i = 0; i < n; i++)
        {
            if(!Character.isDigit(expression.charAt(i)))
            {
                operator.add(expression.charAt(i));

                sp.add(expression.substring(index, i));
                sp.add(expression.substring(i,i+1));
                index = i + 1;
            }

            // 종단 조건
            if(i == n-1)
                sp.add(expression.substring(index,i+1));

        }

        // set을 리스트로 변환
        op = new ArrayList<>(operator);


        m = operator.size();
        visited = new int[m];
        Arrays.fill(visited, 0);
        store = new char[m];
        Arrays.fill(store, 'a');

        // 우선순위
        dfs(0);


        return answer;
    }

    // 우선 순위 정하기
    public static void dfs(int stage)
    {
        if(stage == m)
        {
            ArrayList<String> newsp = sp;

            // 우선순위
            for(int i = 0; i < m; i++)
            {
                int n = newsp.size();
                Stack<String> equ = new Stack<>();

                for(int j = 0; j < n; j++)
                {
                    if(String.valueOf(store[i]).equals(newsp.get(j)))
                    {
                        long front = Long.valueOf(equ.pop());
                        long back = Long.valueOf(newsp.get(j+1));
                        long one = 0;
                        j += 1;

                        if(store[i] == '+')
                            one = front + back;
                        else if(store[i] == '-')
                            one = front - back;
                        else if(store[i] == '*')
                            one = front * back;

                        equ.push(String.valueOf(one));
                    }
                    else
                    {
                        equ.push(newsp.get(j));
                    }
                }

                // 스택을 리스트로 전환
                newsp = new ArrayList<String>(equ);
            }
            // System.out.println(newsp);

            long hubo = Long.valueOf(newsp.get(0));
            if(hubo < 0) hubo = hubo * -1;

            answer = Math.max(answer, hubo);


            return;
        }

        for(int i = 0; i < m; i++)
        {
            if(visited[i] == 0)
            {
                visited[i] = 1;
                store[stage] = op.get(i);
                dfs(stage+1);
                visited[i] = 0;
            }
        }


    }


}
