package programmers.level2;

public class 일이사나라의숫자 {

    public static void main(String[] args) {
        int n1 = 1;
        int n2 = 2;
        int n3 = 3;
        int n4 = 4;

        System.out.println(solution(n1));
        System.out.println(solution(n2));
        System.out.println(solution(n3));
        System.out.println(solution(n4));
    }

    public static String solution(int n) {
        String answer = "";

        // 1 2 4 로 표현
        // 3개가 반복

        // 1 % 3 = 1 -> 1
        // 2 % 3 = 2 -> 2
        // 3 % 3 = 0 -> 4

        // 3으로 나누어떨어지는 경우는 -1을 해야 한다.

        // 작은 것에서부터 큰 것으로 규칙을 찾자.

        String[] hubo = {"4", "1", "2"};

        while(n > 0)
        {
            int index = n % 3;

            n = n / 3;
            if(index == 0) n -= 1;

            // 앞에 붙는다. 진법 계산과 동일
            answer = hubo[index] + answer;
        }

        return answer;
    }

}
