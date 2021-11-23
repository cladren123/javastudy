package programmers.level1;

public class 문자열다루기기본 {

    public static void main(String[] args) {
        
        // 문자열의 길이가 4 ~ 6, 숫자로만 구성되어있는지 확인
        String s1 = "a234";
        String s2 = "1230";

        System.out.println(solution(s1));
        System.out.println(solution(s2));

    }

    public static boolean solution(String s) {
        boolean answer = true;

        int n = s.length();

        if(n != 4 || n != 6) answer = false;
        if(n == 5) answer = false;

        for(int i = 0; i < n; i++)
        {
            if(!Character.isDigit(s.charAt(i))) answer = false;
        }

        return answer;
    }

}
