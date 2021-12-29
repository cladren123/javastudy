package programmers.level3.page1;

//  76.9점
// 시간 초과 발생
// 돈이 없는 경우에는 break를 걸어야 한다. 아니면 계속 트리를 타서 시간초과가 발생한다.
// 100점
// 시간초과해결. 트리 문제에서는 더 이상 트리를 탈 이유가 없을 때를 조건으로 추가해줘서 시간초과를 방지해야한다.

import java.util.*;

public class 다단계칫솔판매 {
    public static void main(String[] args) {

        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        System.out.println(Arrays.toString(solution(enroll, referral, seller, amount)));

    }



    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = {};


        // 자식 부모 순으로 저장
        HashMap<String, String> map = new HashMap<>();

        // 돈 저장
        HashMap<String, Integer> store = new HashMap<>();

        for(int i = 0; i < enroll.length; i++)
        {
            map.put(enroll[i], referral[i]);
        }

        // 금액을 담을 배열 설정
        answer = new int[enroll.length];

        for(int i = 0; i < seller.length; i++)
        {
            String son = seller[i];
            String par = map.get(son);
            int money = amount[i] * 100;

            // center까지 갈 때까지 while문 반복
            while(!son.equals("-"))
            {
                int parmoney = (int)(money * 0.1);
                int sonmoney = money - parmoney;

                store.put(son, store.getOrDefault(son, 0) + sonmoney);

                money = parmoney;

                // 시간초과를 없애는 함수. 굳이 탈 필요가 없는 상황은 탈 필요가 없다.
                if(money < 1) break;

                son = par;

                if(son.equals("-"))
                {
                    store.put(son, store.getOrDefault(son, 0) + money);
                    break;
                }

                par = map.get(son);
            }
        }

        for(int i = 0; i < enroll.length; i++)
        {
            if(store.containsKey(enroll[i]))
                answer[i] = store.get(enroll[i]);
        }



        return answer;
    }
}
