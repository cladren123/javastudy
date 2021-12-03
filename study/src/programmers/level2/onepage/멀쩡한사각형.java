package programmers.level2.onepage;

import java.math.*;

public class 멀쩡한사각형 {

    public static void main(String[] args) {
        int w = 8;
        int h = 12;

        System.out.println(solution(w,h));
    }

    public static long solution(int w, int h) {
        long answer = 1;

        // w : 가로  h : 세로
        // 쓰지 못하는 정사각형의 개수
        // (w / 최대공약수 + h / 최대공약수 - 1) * 최대공약수

        // w,h가 1억 이하의 자연수이기 때문에 long으로 바꿔줘야 한다.

        // 최대공약수
        int gcd = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).intValue();

        long w2 = (long)w;
        long h2 = (long)h;
        long gcd2 = (long)gcd;

        answer = (w2 * h2) - (w2 / gcd2 + h2 / gcd2 - 1) * gcd2;

        return answer;
    }

}
