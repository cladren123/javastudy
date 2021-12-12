package programmers.level2.threepage;

public class 숫자의표현 {

    public static void main(String[] args) {
        int n = 15;
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int answer = 0;

        for(int i = 1; i <= n; i++)
        {
            int result = 0;
            for(int j = i; j <= n; j++)
            {
                result += j;
                if(result == n)
                {
                    answer += 1;
                    break;
                }
                if(result > n)
                    break;

            }
        }
        return answer;
    }

}
