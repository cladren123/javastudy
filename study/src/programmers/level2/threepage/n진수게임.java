package programmers.level2.threepage;

import java.util.*;

public class n진수게임 {

    public static void main(String[] args) {

        int n1 = 2;
        int t1 = 4;
        int m1 = 2;
        int p1 = 1;

        int n2 = 16;
        int t2 = 16;
        int m2 = 2;
        int p2 = 1;

        int n3 = 16;
        int t3 = 16;
        int m3 = 2;
        int p3 = 2;

        System.out.println(solution(n1,t1,m1,p1));
        System.out.println(solution(n2,t2,m2,p2));
        System.out.println(solution(n3,t3,m3,p3));

    }

    public static String solution(int n, int t, int m, int p) {
        String answer = "";

        int num = 0;
        int number = 0;

        // 차례
        int turn = 1;


        while(true)
        {
            // 진수표현하기
            String convnum = "";
            number = num;

            while(number > 0)
            {
                int one = number % n;
                char two = '0';

                if(one <= 9)
                    two = (char)(one + '0');
                else if(one == 10)
                    two = 'A';
                else if(one == 11)
                    two = 'B';
                else if(one == 12)
                    two = 'C';
                else if(one == 13)
                    two = 'D';
                else if(one == 14)
                    two = 'E';
                else if(one == 15)
                    two = 'F';

                convnum = two + convnum;
                number = number / n;
            }


            if(num == 0)
                convnum = "0";




            // 차례에 맞게 answer에 넣기
            int cn = convnum.length();

            // 조건을 만족하면 반복문을 끝내기 위한 변수
            int flag = 0;

            for(int i = 0; i < cn; i++)
            {
                if(turn == p)
                {
                    answer += convnum.charAt(i);
                    if(answer.length() == t)
                    {
                        flag = 1;
                        break;
                    }

                }

                // 차례 초기화
                turn += 1;
                if(turn > m) turn = 1;


                // 조건 만족하면 반복문 종료
                if(flag == 1)
                    break;

            }

            if(flag == 1)
                break;

            num += 1;

        }

        return answer;
    }

}
