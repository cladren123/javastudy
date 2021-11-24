package programmers.level1;

public class 자릿수더하기 {

    public static void main(String[] args) {

        int n1 = 123;
        int n2 = 987;

        System.out.println(solution(n1));
        System.out.println(solution(n2));

    }

    public static int solution(int n) {
        int answer = 0;

        String sn = String.valueOf(n);



        int nlen = sn.length();

        for(int i = 0; i < nlen; i++)
        {
            int one = (int)(sn.charAt(i) - '0');
            answer += one;
        }

        return answer;
    }


}
