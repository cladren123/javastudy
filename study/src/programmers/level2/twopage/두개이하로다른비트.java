package programmers.level2.twopage;

import java.util.*;

public class 두개이하로다른비트 {

    public static void main(String[] args) {
        long[] numbers = {2,7};

        System.out.println(Arrays.toString(solution(numbers)));
    }

    public static long[] solution(long[] numbers) {
        long[] answer = {};

        int n = numbers.length;

        ArrayList<Long> alist = new ArrayList<Long>();

        // 짝수랑 홀수랑 다르다.
        // 짝수 +1
        // 홀수 +1 했을 때 앞자리가 바뀌면 두번째 앞자리를 0으로 바꾼다.
        // 7 = 111, 11 = 1011
        // 자릿수가 변하지 않으면 마지막 0을 1로 바꾸고 뒤에 1을 0으로 바꾼다.
        for(int i = 0; i < n; i++)
        {
            long one = numbers[i];

            String bione = Long.toBinaryString(one);
            String bitwo = Long.toBinaryString(one+1);

            // 짝수일 때
            if(one % 2 == 0)
            {
                alist.add(one + 1);
            }
            // 홀수일 때
            else
            {
                // 자릿수가 변하지 않을 때
                // 마지막 0을 1로 바꾸고 뒤의 1을 0으로 바꾼다.
                if(bione.length() == bitwo.length())
                {
                    char[] charr = bione.toCharArray();
                    for(int j = charr.length - 1; j >= 0; j--)
                    {
                        if(charr[j] == '0')
                        {
                            charr[j] = '1';
                            charr[j+1] = '0';
                            break;
                        }
                    }

                    bione = new String(charr);
                    one = Long.parseLong(bione, 2);
                    alist.add(one);

                }
                // 변할 때
                else
                {

                    bione += "1";
                    char[] charr = bione.toCharArray();
                    charr[1] = '0';
                    bione = new String(charr);
                    one = Long.parseLong(bione, 2);
                    alist.add(one);

                }
            }
        }



        answer = new long[n];
        for(int i = 0; i < n; i++)
            answer[i] = alist.get(i);


        return answer;
    }

}
