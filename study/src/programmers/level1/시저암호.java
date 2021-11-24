package programmers.level1;

public class 시저암호 {

    public static void main(String[] args) {

        String s1 = "AB";
        int n1 = 1;

        String s2 = "z";
        int n2 = 1;

        String s3 = "a B z";
        int n3 = 4;

        System.out.println(solution(s1, n1));
        System.out.println(solution(s2, n2));
        System.out.println(solution(s3, n3));

    }

    public static String solution(String s, int n) {
        String answer = "";

        int m = s.length();

        for(int i = 0; i < m; i++)
        {
            char one = s.charAt(i);
            if(Character.isLetter(one))
            {
                int two = (int)one;

                if(two >= 97 )
                {
                    two += n;
                    if(two > 122) two -= 26;
                }

                else if(two >= 65)
                {
                    two += n;
                    if(two > 90) two -= 26;
                }

                one = (char)two;
            }

            answer += one;

        }



        return answer;
    }

}
