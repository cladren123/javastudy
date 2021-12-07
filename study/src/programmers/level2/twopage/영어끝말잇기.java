package programmers.level2.twopage;

import java.util.*;

public class 영어끝말잇기 {

    public static void main(String[] args) {

        int n1 = 3;
        String[] words1 = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};

        int n2 = 5;
        String[] words2 = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};

        int n3 = 2;
        String[] words3 = {"hello", "one", "even", "never", "now", "world", "draw"};

        System.out.println(Arrays.toString(solution(n1, words1)));
        System.out.println(Arrays.toString(solution(n2, words2)));
        System.out.println(Arrays.toString(solution(n3, words3)));

    }

    public static int[] solution(int n, String[] words) {
        int[] answer = {};
        answer = new int[2];
        answer[0] = 0;
        answer[1] = 0;

        int wn = words.length;

        // 사람차례
        int human = 1;
        // 차례
        int count = 1;

        HashMap<String, Integer> map = new HashMap<>();

        // 처음값을 넣는다.
        map.put(words[0], 1);
        String back = words[0];

        for(int i = 1; i < wn; i++)
        {
            String one = words[i];

            human += 1;

            if(human > n) {
                human = 1;
                count += 1;
            }

            // 포함되었거나 끝말이 다르면
            if(map.containsKey(one) || one.charAt(0) != back.charAt(back.length()-1))
            {
                answer[0] = human;
                answer[1] = count;
                break;
            }
            else
            {
                map.put(one, 1);
            }

            back = one;

        }

        return answer;
    }


}
