package programmers.level3.page1;

import java.util.*;

public class 표편집 {

    public static void main(String[] args) {

        int n = 8;
        int k = 2;
        String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};

        System.out.println(solution(n,k,cmd));

    }




    public static String solution(int n, int k, String[] cmd) {
        String answer = "";


        // 삭제된 것을 저장
        Stack<Integer> stack = new Stack<>();
        int size = n;

        for(int i = 0; i < cmd.length; i++)
        {
            String[] sp = cmd[i].split(" ");

            // 내려갑니다.
            if(sp[0].equals("D"))
            {
                int move = Integer.parseInt(sp[1]);
                k += move;
            }
            // 올라갑니다.
            else if(sp[0].equals("U"))
            {
                int move = Integer.parseInt(sp[1]);
                k -= move;
            }
            // 삭제
            else if(sp[0].equals("C"))
            {
                stack.push(k);
                size -= 1;

                // 마지막 것을 삭제하면 커서를 위로 올린다.
                if(k == size)
                    k -= 1;

            }
            // 되돌리기
            else if(sp[0].equals("Z"))
            {
                int val = stack.pop();

                // 현재 커서보다 작은 것이 다시 돌아오면 같은 것을 가르키기 위해 +1
                if(val <= k)
                {
                    k += 1;
                }
                size += 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i++)
            sb.append("O");

        while(!stack.isEmpty())
        {
            int one = stack.pop();
            sb.insert(one, 'X');
        }

        return sb.toString();
    }
}
