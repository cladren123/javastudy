package programmers.level3.page2;

public class 광고삽입2트 {


    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";

        int playtime = timeToInt(play_time);
        int advtime = timeToInt(adv_time);

        long[] allplaytime = new long[playtime+1];

        for(String one : logs)
        {
            String[] sp = one.split("-");
            int start = timeToInt(sp[0]);
            int end = timeToInt(sp[1]);

            allplaytime[start] += 1;
            allplaytime[end] -= 1;
        }

        // 현재 동영상을 시청하고 있는 사람의 수
        for(int i = 1; i <= playtime; i++)
            allplaytime[i] += allplaytime[i-1];

        // 현재 시간까지 동영상을 시청한 총 재생시간
        for(int i = 1; i <= playtime; i++)
            allplaytime[i] += allplaytime[i-1];

        long maxtime = allplaytime[advtime-1];
        int maxstarttime = 0;

        for(int i = 0; i + advtime <= playtime; i++)
        {
            long temp = allplaytime[i + advtime] - allplaytime[i];

            if(temp > maxtime)
            {
                maxtime = temp;
                maxstarttime = i+1;
            }
        }



        answer = String.format("%02d:%02d:%02d", maxstarttime / 3600, (maxstarttime / 60) % 60, maxstarttime % 60);


        return answer;
    }


    public int timeToInt(String time)
    {
        int[] parse = Arrays.stream(time.split(":")).mapToInt(Integer::parseInt).toArray();

        return parse[0] * 3600 + parse[1] * 60 + parse[2];
    }
}
