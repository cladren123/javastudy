package programmers.level2.threepage;

public class 모음사전 {

    public static void main(String[] args) {

        String word1 = "AAAAE";
        String word2 = "AAAE";
        String word3 = "I";
        String word4 = "EIO";

        System.out.println(solution(word1));
        System.out.println(solution(word2));
        System.out.println(solution(word3));
        System.out.println(solution(word4));

    }

    public static int solution(String word) {
        int answer = 0;


        // A E I O U
        // A = 1, I = 1563
        // 781의 차이
        // 첫번째 자리 : +1
        // 두번째 자리 : +6
        // 세번째 자리 : +31
        // 네번쩨 자리 : +156
        // 다섯번째 자리 : +781

        int gan = 781;

        int n = word.length();
        char[] arr = {'A','E','I','O','U'};

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                if(word.charAt(i) == arr[j])
                {
                    answer += 1 + j * gan;
                }
            }

            gan = (gan - 1)/5;
        }

        return answer;
    }
}
