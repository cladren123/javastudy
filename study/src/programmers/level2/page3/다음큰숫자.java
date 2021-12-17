package programmers.level2.page3;

public class 다음큰숫자 {

    public static void main(String[] args) {

        int n1 = 78;
        int n2 = 15;

        System.out.println(solution(n1));
        System.out.println(solution(n2));

    }


    public static int solution(int n) {
        int answer = 0;

        // 2진수로 변환
        String con = Integer.toBinaryString(n);
        int conn = con.length();

        int one = 0;

        for(int i = 0; i < conn; i++)
            if(con.charAt(i) == '1')
                one += 1;

        while(true)
        {
            n++;
            String con2 = Integer.toBinaryString(n);
            int conn2 = con2.length();
            int one2 = 0;
            for(int i = 0; i < conn2; i++)
                if(con2.charAt(i) == '1')
                    one2 += 1;

            if(one == one2)
            {
                answer = n;
                break;
            }
        }
        return answer;
    }

}
