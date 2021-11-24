package programmers.level1;



public class 약속의합 {

    public static void main(String[] args) {

        int n1 = 12;
        int n2 = 5;

        System.out.println(solution(n1));
        System.out.println(solution(n2));

    }

    public static int solution(int n) {
        int answer = 0;

        for(int i = 1; i <= n; i++)
        {
            if(n % i == 0) answer += i;
        }

        return answer;
    }

}
