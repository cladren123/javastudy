package studyGroup.June.june16;

import java.awt.print.Pageable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class 백준2493탑 {

    static int[] board;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        board = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<int[]> stack = new Stack<>();




        for(int i = 1; i <= n; i++)
        {
            int top = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty())
            {
                if(stack.peek()[1] >= top)
                {
                    System.out.println(stack.peek()[0] + " ");
                    break;
                }
                stack.pop();
            }
            if(stack.isEmpty())
            {
                System.out.println("0 ");
            }
            stack.push(new int[] {i, top});

        }






    }

    public static class dot
    {
        int index;
        int value;

        dot(int index, int value)
        {
            this.index = index;
            this.value = value;
        }
    }



}
