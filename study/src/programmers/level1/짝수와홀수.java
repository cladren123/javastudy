package programmers.level1;

public class 짝수와홀수 {

    public static void main(String[] args) {

        int num1 = 3;
        int num2 = 4;

        System.out.println(solution(num1));
        System.out.println(solution(num2));
    }

    public static String solution(int num) {
        String answer = "";

        if(num % 2 == 0) answer += "Even";
        else answer += "Odd";

        return answer;
    }

}
