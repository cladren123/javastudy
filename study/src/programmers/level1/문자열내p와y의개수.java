package programmers.level1;



public class 문자열내p와y의개수 {

    public static void main(String[] args) {

        String s1 = "pPoooyY";
        String s2 = "Pyy";

        System.out.println(solution(s1));
        System.out.println(solution(s2));

    }


    static boolean solution(String s) {
        boolean answer = true;

        int p = 0;
        int y = 0;

        int n = s.length();

        for(int i = 0; i < n; i++)
        {
            if(s.charAt(i) == 'p' || s.charAt(i) == 'P') p += 1;
            if(s.charAt(i) == 'y' || s.charAt(i) == 'Y') y += 1;
        }

        if(p == y) answer = true;
        else answer = false;

        return answer;
    }

}
