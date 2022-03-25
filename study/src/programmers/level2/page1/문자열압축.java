package programmers.level2.page1;

public class 문자열압축 {

    public static void main(String[] args) {

        String s1 = "aabbaccc";
        String s2 = "ababcdcdababcdcd";
        String s3 = "abcabcdede";
        String s4 = "abcabcabcabcdededededede";
        String s5 = "xababcdcdababcdcd";


        // 테스트케이스 5번
        String s6 = "a";
        System.out.println(solution(s6));

    }

    // 압축 길이 1,2,3...
    // 인덱스

    public static int solution(String s) {
        // 문자의 최대 길이가 1000이이서 1001로 설정


        int n = s.length();

        int answer = n;

        int m = (int)n / 2;



        // 갯수
        for(int i = 1; i <= m; i++)
        {
            String news = s;

            String comp = "";
            String pattern = "";

            // 초기값 설정
            pattern = news.substring(0, i);
            int count = 1;
            int check = 0;

            for(int j = i; j+i <= n; j += i)
            {
                if(pattern.equals(news.substring(j,j+i)))
                {
                    count += 1;
                }
                else
                {
                    if(count > 1) {
                        comp += count;
                        count = 1;
                    }
                    comp += pattern;
                    pattern = news.substring(j,j+i);
                }

                // 종단조건
                if(j+i+i > n )
                {
                    if(count > 1) {
                        comp += count;
                        count = 1;
                    }
                    comp += pattern;
                    pattern = news.substring(j,j+i);

                    check = j + i;
                }
            }

            // 문장 완성
            comp += news.substring(check, n);


//            System.out.println(comp);
            answer = Math.min(answer, comp.length());

        }

        return answer;
    }
}



