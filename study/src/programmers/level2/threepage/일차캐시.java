package programmers.level2.threepage;

import java.util.*;
import java.lang.*;

public class 일차캐시 {
    public static void main(String[] args) {

        int cacheSize1 = 3;
        String[] cities1 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

        int cacheSize2 = 3;
        String[] cities2 = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};


        int cacheSize3 = 2;
        String[] cities3 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};


        int cacheSize4 = 5;
        String[] cities4 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};


        int cacheSize5 = 2;
        String[] cities5 = {"Jeju", "Pangyo", "NewYork", "newyork"};


        int cacheSize6 = 0;
        String[] cities6 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

        System.out.println(solution(cacheSize1, cities1));
        System.out.println(solution(cacheSize2, cities2));
        System.out.println(solution(cacheSize3, cities3));
        System.out.println(solution(cacheSize4, cities4));
        System.out.println(solution(cacheSize5, cities5));
        System.out.println(solution(cacheSize6, cities6));

    }

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;

        int n = cities.length;

        LinkedList<String> cache = new LinkedList<>();

        for(int i = 0; i < n; i++)
        {
            String one = cities[i].toLowerCase();
            int flag = 0;
            for(int j = 0; j < cache.size(); j++)
            {
                // 캐시히트
                if(cache.get(j).equals(one))
                {
                    flag = 1;
                    answer += 1;

                    cache.remove(j);

                    break;
                }
            }

            cache.addFirst(one);

            // 캐시미스
            if(flag == 0)
            {
                answer += 5;

                if(cache.size() > cacheSize)
                    cache.removeLast();
            }

        }

        return answer;

    }
}
