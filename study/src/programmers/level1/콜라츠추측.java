package programmers.level1;

public class 콜라츠추측 {

    public static void main(String[] args) {

        int n1 = 6;
        int n2 = 16;
        int n3 = 626331;

        System.out.println(solution(n1));
        System.out.println(solution(n2));
        System.out.println(solution(n3));

    }

    public static int solution(int num) {
        int answer = 0;

        while(num != 1)
        {
            if(num % 2 == 0) num = num / 2;
            else if(num % 2 == 1) num = num * 3 + 1;
            answer += 1;

            if(answer > 500) break;
        }

        if(answer > 500) answer = -1;

        return answer;
    }
}
