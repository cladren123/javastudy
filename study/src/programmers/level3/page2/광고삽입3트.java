package programmers.level3.page2;

import java.util.*;

// 마지막을 포함하지 않았기 때문에 누적합을 사용할 수 있었다.

public class 광고삽입3트 {

    public static void main(String[] args) {

        String play_time = "02:03:55";
        String adv_time = "00:14:15";
        String[] logs = {"01:20:15-01:45:14",
        "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};

        System.out.println(solution(play_time, adv_time, logs));

    }

    public static String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";

        int playTime = timeToInt(play_time);
        int advTime = timeToInt(adv_time);

        long[] board = new long[playTime+1];

        for(String one : logs)
        {
            String[] sp = one.split("-");

            int start = timeToInt(sp[0]);
            int end = timeToInt(sp[1]);

            board[start] += 1;
            board[end] -= 1;
        }


        for(int i = 1; i <= playTime; i++)
            board[i] += board[i-1];

        for(int i = 1; i <= playTime; i++)
            board[i] += board[i-1];

        long maxTime = board[advTime-1];
        int startIndex = 0;

        for(int i = 0; i <= playTime - advTime; i++)
        {
            long temp = board[i + advTime] - board[i];

            if(temp > maxTime)
            {
                maxTime = temp;
                startIndex = i+1;
            }
        }




        answer = String.format("%02d:%02d:%02d", startIndex / 3600, (startIndex / 60) % 60, startIndex % 60);




        return answer;
    }


    public static int timeToInt(String timeOne)
    {

        String[] sp = timeOne.split(":");

        int result = Integer.valueOf(sp[0]) * 3600 + Integer.valueOf(sp[1]) * 60 + Integer.valueOf(sp[2]);

        return result;

    }


}
