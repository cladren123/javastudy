package programmers.level2.page4;

public class JadenCase문자열만들기 {

    public static void main(String[] args) {
        String s1 = "3people unFollowed me";
        String s2 = "for the last week";

        System.out.println(solution(s1));
        System.out.println(solution(s2));
    }

    public static String solution(String s) {
        String answer = "";

        s = s.toLowerCase();

        int n = s.length();

        int flag = 1;

        for(int i = 0; i < n; i++)
        {
            if(flag == 1 && s.charAt(i) != ' ')
            {
                char[] arr = s.toCharArray();
                arr[i] = Character.toUpperCase(arr[i]);
                s = new String(arr);
                flag = 0;
            }

            if(s.charAt(i) == ' ')
            {
                flag = 1;
            }
        }

        answer = s;

        return answer;
    }

}
