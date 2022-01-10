package programmers.level3.page3;

// 출저 : https://iron-jin.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%8A%A4%ED%8B%B0%EC%BB%A4-%EB%AA%A8%EC%9C%BC%EA%B8%B02

import java.util.*;

public class 스티커모으기2 {

    public static void main(String[] args) {

        int[] sticker = {14, 6, 5, 11, 3, 9, 2, 10};

        System.out.println(solution(sticker));

    }

    public static int solution(int sticker[]) {
        int answer = 0;

        int n = sticker.length;

        if(n==1) return sticker[0];

        int[] dp1 = new int[n]; // 첫번째 스티커를 붙힌 경우
        int[] dp2 = new int[n]; // 첫번째 스티커를 붙히지 않은 경우

        dp1[0] = sticker[0];
        dp1[1] = sticker[0];

        for(int i = 2; i < n-1; i++)
        {
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + sticker[i]);
        }

        dp2[0] = 0;
        dp2[1] = sticker[1];

        for(int i = 2; i < n; i++)
        {
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + sticker[i]);
        }

        answer = Math.max(dp1[n-2], dp2[n-1]);




        return answer;
    }

}
