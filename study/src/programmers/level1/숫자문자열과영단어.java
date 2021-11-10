package programmers.level1;

public class 숫자문자열과영단어 {

    public static void main(String[] args) {

        String s1 = "one4seveneight";
        System.out.println(solution(s1));

        String s2 = "23four5six7";
        System.out.println(solution(s2));

        String s3 = "2three45sixseven";
        System.out.println(solution(s3));

        String s4 = "123";
        System.out.println(solution(s4));


    }


    // 답 코드 구현
    public static int solution(String s) {
        int answer = 0;

        s = s.replace("zero", "0");
        s = s.replace("one", "1");
        s = s.replace("two", "2");
        s = s.replace("three", "3");
        s = s.replace("four", "4");
        s = s.replace("five", "5");
        s = s.replace("six", "6");
        s = s.replace("seven", "7");
        s = s.replace("eight", "8");
        s = s.replace("nine", "9");


        answer = Integer.parseInt(s);


        return answer;
    }


}
