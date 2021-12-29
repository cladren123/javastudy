package programmers.level3.page1;

import java.util.*;

public class 추석트래픽 {

    public static void main(String[] args) {

        String[] lines1 = {"2016-09-15 00:00:00.000 3s"};
        // 홈페이지에 테스트 6까지 있다.

        System.out.println(solution(lines1));

    }

    public static int solution(String[] lines) {
        int answer = 0;

        int linesn = lines.length;

        long[][] list = new long[linesn][2];

        for(int i = 0; i < linesn; i++)
        {
            String[] sp = lines[i].split(" ");

            String[] times = sp[1].split(":");

            double endtime = Double.parseDouble(times[0]) * 3600 + Double.parseDouble(times[1]) * 60 + Double.parseDouble(times[2]);

            long etime = (long)(endtime * 1000);

            String dur = sp[2].substring(0, sp[2].length() - 1);

            double starttime = (endtime - Double.parseDouble(dur) + 0.001) * 1000;

            long stime = (long)starttime;

            list[i][0] = stime;
            list[i][1] = etime;

        }

        // for(int i = 0; i < linesn; i++)
        //     System.out.println(Arrays.toString(list[i]));


        for(int i = 0; i < linesn; i++)
        {
            long one = list[i][1] + 1000;

            int result = 0;

            for(int j = i; j < linesn; j++)
            {
                if(list[j][0] < one)
                    result += 1;
            }


            answer = Math.max(answer, result);
        }





        return answer;
    }

}
