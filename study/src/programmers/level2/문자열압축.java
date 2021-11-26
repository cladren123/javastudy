package programmers.level2;

public class 문자열압축 {

    public static void main(String[] args) {

        String s1 = "aabbaccc";
        String s2 = "ababcdcdababcdcd";
        String s3 = "abcabcdede";
        String s4 = "abcabcabcabcdededededede";
        String s5 = "xababcdcdababcdcd";

//        System.out.println(solution(s1));
//        System.out.println(solution(s2));
//        System.out.println(solution(s3));
//        System.out.println(solution(s4));
        System.out.println(solution(s5));

    }

    // 압축 길이 1,2,3...
    // 인덱스

    public static int solution(String s) {
        int answer = 1000;

        int n = s.length();
        int m = (int)n / 2;

        // 갯수
        for(int i = 1; i <= m; i++)
        {
            String news = s;

            String comp = "";
            String pattern = "";

            // 시작 인덱스
            


        }

        return answer;
    }
}
