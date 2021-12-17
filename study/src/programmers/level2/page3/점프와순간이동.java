package programmers.level2.page3;

public class 점프와순간이동 {

    public static void main(String[] args) {

        int n1 = 5;
        int n2 = 6;
        int n3 = 5000;

        System.out.println(solution(n1));
        System.out.println(solution(n2));
        System.out.println(solution(n3));

    }

    public static int solution(int n) {

        int ans = 0;

        while( n != 0 )
        {
            // n이 짝수인 경우 배터리 소비 없이 2로 나눈다.
            if(n % 2 == 0)
                n = n/2;
                // 홀수인 경우 배터리를 소비하고 한 칸 뒤로 간다.
            else
            {
                ans += 1;
                n -= 1;
            }
        }

        return ans;

    }

}
