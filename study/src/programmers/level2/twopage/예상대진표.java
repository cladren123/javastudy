package programmers.level2.twopage;

public class 예상대진표 {

    public static void main(String[] args) {
        int n = 8;
        int a = 4;
        int b = 7;

        System.out.println(solution(n,a,b));
    }

    public static int solution(int n, int a, int b)
    {
        int answer = 0;

        while(a != b)
        {
            answer += 1;

            if(a%2 == 1)
                a = (int)a/2 + 1;
            else
                a = (int)a/2;

            if(b%2 == 1)
                b = (int)b/2 + 1;
            else
                b = (int)b/2;

        }



        return answer;
    }

}
