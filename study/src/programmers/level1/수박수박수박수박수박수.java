package programmers.level1;

public class 수박수박수박수박수박수 {

    public static void main(String[] args) {

        int n1 = 3;
        int n2 = 4;

        System.out.println(solution(n1));
        System.out.println(solution(n2));

    }

    public static String solution(int n) {
        String answer = "";

        for(int i = 1; i <= n; i++)
        {
            if(i % 2 == 1) answer += "수";
            else answer += "박";
        }

        return answer;
    }

}
