package programmers.level1;

public class 소수찾기 {

    public static void main(String[] args) {

        int n1 = 10;
        int n2 = 5;

        System.out.println(solution(n1));
        System.out.println(solution(n2));

    }

    public static int solution(int n) {
        int answer = 0;

        for(int i = 1; i <= n; i++)
        {
            int check = 0;
            for(int j = 1; j <= Math.sqrt(i); j++)
            {
                if(i % j == 0) check +=1;
            }

            if(check == 1)
            {
                answer += 1;
            }

        }


        return answer-1;
    }
}
