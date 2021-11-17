package programmers.level1;

import java.util.*;
import java.lang.*;

public class 실패율 {
    public static void main(String[] args) {
        int n1 = 5;
        int[] stages1 = {2,1,2,6,2,4,3,3};

        int n2 = 4;
        int[] stages2 = {4,4,4,4,4};

        System.out.println(Arrays.toString(solution(n1, stages1)));
        System.out.println(Arrays.toString(solution(n2, stages2)));

    }

    // 내림차순 : 큰 숫자에서 작은 숫자

    static class Rate{
        Integer idx;
        Double rate;

        public Rate(Integer idx, Double rate) {
            this.idx = idx;
            this.rate = rate;
        }
    }

    public static int[] solution(int N, int[] stages) {

        Double[] nowplayer = new Double[N+2];
        Arrays.fill(nowplayer, 0.0);

        Double[] clearplayer = new Double[N+2];
        Arrays.fill(clearplayer, 0.0);

        for(int i : stages)
        {
            nowplayer[i] += 1;
            for(int j = 1; j <= i; j++) clearplayer[j] += 1;
        }

//        System.out.println(Arrays.toString(nowplayer));
//        System.out.println(Arrays.toString(clearplayer));

        ArrayList<Rate> array = new ArrayList<>();
        for(int i = 1; i < N+1; i++)
        {
            if(clearplayer[i] == 0 )
            {
                array.add(new Rate(i, 0.0));
                continue;
            }

            Double rate = nowplayer[i] / clearplayer[i];
            array.add(new Rate(i, rate));
        }

        Collections.sort(array, ((o1, o2) -> Double.compare(o2.rate, o1.rate)));

        int[] answer = new int[N];
        for(int i = 0; i < array.size(); i++)
        {
            answer[i] = array.get(i).idx;
        }

        return answer;
    }

}
