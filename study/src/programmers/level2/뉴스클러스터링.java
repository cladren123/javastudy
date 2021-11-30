package programmers.level2;

import java.util.*;
import java.lang.*;
import java.io.*;

public class 뉴스클러스터링 {

    public static void main(String[] args) {
        String str11 = "FRANCE";
        String str21 = "french";

        String str12 = "handshake";
        String str22 = "shake hands";

        String str13 = "aa1+aa2";
        String str23 = "AAAA12";

        String str14 = "E=M*C^2";
        String str24 = "e=m*c^2";

        System.out.println(solution(str11, str21));
        System.out.println(solution(str12, str22));
        System.out.println(solution(str13, str23));
        System.out.println(solution(str14, str24));


    }

    public static int solution(String str1, String str2) {
        int answer = 0;

        // 소문자로 변환
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        HashMap<String,Integer> map1 = new HashMap<>();
        HashMap<String,Integer> map2 = new HashMap<>();

        int n1 = str1.length();
        int n2 = str2.length();

        for(int i = 0; i < n1-1; i++)
        {
            String one = str1.substring(i,i+2);

            int count = 0;

            for(int j = 0; j < 2; j++)
            {
                char ch = one.charAt(j);
                if(ch >= 'a' && ch <= 'z') count += 1;
            }

            if(count == 2) map1.put(one, map1.getOrDefault(one, 0) + 1);
        }

        for(int i = 0; i < n2-1; i++)
        {
            String one = str2.substring(i,i+2);

            int count = 0;

            for(int j = 0; j < 2; j++)
            {
                char ch = one.charAt(j);
                if(ch >= 'a' && ch <= 'z') count += 1;
            }

            if(count == 2) map2.put(one, map2.getOrDefault(one, 0) + 1);
        }

        int gyo = 0;
        int hap = 0;

        for(String key1 : map1.keySet())
        {
            for(String key2 : map2.keySet())
            {

                if(key1.equals(key2))
                {

                    gyo += Math.min(map1.get(key1), map2.get(key2));
                    hap += Math.max(map1.get(key1), map2.get(key2));

                    map1.put(key1,0);
                    map2.put(key2,0);
                }
            }
        }

        for(String key : map1.keySet()) hap += map1.get(key);
        for(String key : map2.keySet()) hap += map2.get(key);

        // 두 개의 집합이 모두 공집합
        if(gyo == 0 && hap == 0) answer = 65536;
        else answer = (int)((float)gyo / (float)hap * 65536);

        return answer;
    }

}
