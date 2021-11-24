package programmers.level1;



public class 정수제곱근판별 {

    public static void main(String[] args) {

        long n1 = 121;
        long n2 = 3;

        System.out.println(solution(n1));
        System.out.println(solution(n2));

    }

    public static long solution(long n) {
        long answer = 0;

        long sq = (long)(Math.sqrt(n));

        if(sq*sq == n) answer = (sq+1) * (sq+1);
        else answer -= 1;

        return answer;
    }

}
