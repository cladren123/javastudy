package programmers.level2.threepage;

public class 방금그곡 {

    public static void main(String[] args) {

        String m1 = "ABCDEFG";
        String[] musicinfos1 = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};

        String m2 = "CC#BCC#BCC#BCC#B";
        String[] musicinfos2 = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};

        String m3 = "ABC";
        String[] musicinfos3 = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};

        System.out.println(solution(m1,musicinfos1));
        System.out.println(solution(m2,musicinfos2));
        System.out.println(solution(m3,musicinfos3));

    }

    public static String solution(String m, String[] musicinfos) {
        String answer = "(None)";

        int n = musicinfos.length;

        // 두 글자 음을 한 글자로 변환
        m = convert(m);
        int mlength = m.length();

        int aplaytime = 0;


        for(int i = 0; i < n; i++)
        {
            String[] one = musicinfos[i].split(",");

            // 재생시간 구하기
            String[] time1 = one[0].split(":");
            String[] time2 = one[1].split(":");

            int playtime = (Integer.parseInt(time2[0]) - Integer.parseInt(time1[0])) * 60
                    + (Integer.parseInt(time2[1]) - Integer.parseInt(time1[1]) ) + 1;
            // 재생시간 구하기

            // 멜로디 구하기
            String melody = "";
            String convmelody = convert(one[3]);
            int mn = convmelody.length();
            int mindex = 0;
            for(int j = 0; j < playtime; j++)
            {
                melody += convmelody.charAt(mindex);

                // mindex % mn 을 쓰는 방법도 있다.
                mindex += 1;
                if(mindex >= mn) mindex = 0;
            }
            // 멜로디 구하기

            // 멜로디 비교하기
            int flag2 = 0;
            for(int j = 0; j < playtime - mlength; j++)
            {
                flag2 = 0;
                for(int k = 0; k < mlength; k++)
                {
                    if(melody.charAt(j+k) != m.charAt(k))
                    {
                        break;
                    }
                    else
                        flag2 += 1;
                }

                if(flag2 == mlength)
                    break;
            }


            // 멜로디 비교하기

            // 정답 조건에 부합한거 찾기
            // 재생 시간이 제일 긴 음악 제목, 먼저 입력된 음악 제목 반환
            if(melody.contains(m))
            {
                if(aplaytime < playtime)
                {
                    aplaytime = playtime;
                    answer = one[2];
                }
            }

        }

        return answer;
    }

    // 두 글자의 음표를 한 글자의 음표로 치환
    public static String convert(String one)
    {
        String result = one;

        result = result.replaceAll("C#", "c");
        result = result.replaceAll("D#", "d");
        result = result.replaceAll("F#", "f");
        result = result.replaceAll("G#", "g");
        result = result.replaceAll("A#", "a");

        return result;
    }

}
