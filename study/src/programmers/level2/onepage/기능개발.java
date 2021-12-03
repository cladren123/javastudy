package programmers.level2.onepage;

import java.util.*;
import java.math.*;

public class 기능개발 {

    public static void main(String[] args) {

        int[] progresses1 = {93, 39,55};
        int[] speeds1 = {1,30,5};

        int[] progresses2 = {95, 90, 99, 99, 80, 99};
        int[] speeds2 = {1,1,1,1,1,1};

        System.out.println(Arrays.toString(solution(progresses1, speeds1)));
        System.out.println(Arrays.toString(solution(progresses2, speeds2)));

    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        int n = progresses.length;

        ArrayList<Integer> days = new ArrayList<Integer>();

        for(int i = 0; i < n; i++)
        {
            days.add((int)Math.ceil((100.0 - (double)progresses[i]) / (double)speeds[i]));
        }
        days.add(0);

        // 각 배포마다 몇개의 기능이 배포되는지

        ArrayList<Integer> store = new ArrayList<Integer>();


        int count = 0;
        int check = days.get(0);

        for(int i = 0; i < n+1; i++)
        {
            if(days.get(i) > check || i == n)
            {
                store.add(count);
                count = 1;
                check = days.get(i);
            }
            else count += 1;
        }


        int m = store.size();

        answer = new int[m];

        for(int i = 0; i < m; i++)
        {
            answer[i] = store.get(i);
        }

        return answer;
    }
}
