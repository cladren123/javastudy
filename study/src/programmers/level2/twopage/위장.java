package programmers.level2.twopage;

import java.util.*;

public class 위장 {

    public static void main(String[] args) {

        String[][] clothes1 = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] clothes2 = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};

        System.out.println(solution(clothes1));
        System.out.println(solution(clothes2));

    }

    public static int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();

        int n = clothes.length;

        for(int i = 0; i < n; i++)
        {
            String pro = clothes[i][0];
            String category = clothes[i][1];

            map.put(category, map.getOrDefault(category,0) + 1);
        }

        // 경우의 수를 헤아린다.
        // 헤드기어가 2개 있으면 경우의 수는 3개 : 쓰지않음, 1번씀, 2번씀

        for(String key : map.keySet())
        {
            answer = answer * (map.get(key)+1);
        }

        // 모두 안 쓴 경우는 제외한다.
        answer -= 1;



        return answer;
    }
}
