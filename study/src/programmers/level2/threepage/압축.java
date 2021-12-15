package programmers.level2.threepage;

import java.util.*;

public class 압축 {

    public static void main(String[] args) {

        String msg1 = "KAKAO";
        String msg2 = "TOBEORNOTTOBEORTOBEORNOT";
        String msg3 = "ABABABABABABABAB";

        System.out.println(solution(msg1));
        System.out.println(solution(msg2));
        System.out.println(solution(msg3));

    }

    public static ArrayList<Integer> solution(String msg) {

        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        int index = 0;

        // Character는 +1을 할 수 없다.
        char one = 'A';

        // 기본인덱스 만들기
        for(int i = 0; i < 26; i++)
        {
            String sone = "" + one;
            index += 1;
            map.put(sone, index);
            one += 1;
        }



        // 탐색
        int n = msg.length();

        String store1 = "";
        String store2 = "";

        for(int i = 0; i < n; i++)
        {
            store1 += msg.charAt(i);

            // 사전에 없다면 사전에 추가
            if(!map.containsKey(store1))
            {
                index += 1;
                map.put(store1, index);
                answer.add(map.get(store2));
                store1 = "" + msg.charAt(i);
                store2 = "";
            }

            store2 += msg.charAt(i);

            // 마지막 단어
            if(i == n-1)
            {
                answer.add(map.get(store2));
            }

        }


        // System.out.println(answer);


        return answer;
    }

}
