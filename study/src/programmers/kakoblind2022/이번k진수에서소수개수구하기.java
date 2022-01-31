package programmers.kakoblind2022;

// 진수변환
// 0을 기준으로 나누기
// 소수인지 확인
// 1번 11번 런타임 에러는 소수판별 함수에서 int를 long으로 바꾸어 해결했다.

import java.util.*;

public class 이번k진수에서소수개수구하기 {

    public static void main(String[] args) {

        int n = 437674;
        int k = 3;

        System.out.println(solution(n,k));

    }

    public static int solution(int n, int k) {
        int answer = 0;

        String primeNumber = "";

        int newn = n;

        while(newn != 0)
        {
            int remainder = newn % k;
            newn = newn / k;

            primeNumber = String.valueOf(remainder) + primeNumber;
        }



        String store = "";

        for(int i = 0; i < primeNumber.length(); i++)
        {
            if(primeNumber.charAt(i) != '0') store += primeNumber.charAt(i);

            if(primeNumber.charAt(i) == '0' || i == primeNumber.length() - 1)
            {
                if(store.equals("")) continue;
                if(check(store)) answer += 1;
                store = "";
            }

        }

        return answer;
    }


    // 소수를 판단해주는 함수
    public static boolean check(String one)
    {
        long number = Long.valueOf(one);

        if(number == 1 || number == 0) return false;


        for(int i = 2; i <= (int)Math.sqrt(number); i++)
        {
            if(number % i == 0) return false;
        }

        return true;

    }




}
