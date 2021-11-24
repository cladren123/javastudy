package programmers.level1;

public class 핸드폰번호가리기 {

    public static void main(String[] args) {
        String phone_number1 = "01033334444";
        String phone_number2 = "027778888";

        System.out.println(solution(phone_number1));
        System.out.println(solution(phone_number2));
    }

    public static String solution(String phone_number) {
        String answer = "";

        int n = phone_number.length();

        for(int i = 0; i < n-4; i++)
            answer += "*";

        answer += phone_number.substring(n-4,n);


        return answer;
    }


}
