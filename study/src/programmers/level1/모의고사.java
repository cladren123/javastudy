package programmers.level1;

import java.util.*;
import java.lang.*;
import java.io.*;

public class 모의고사 {
    public static void main(String[] args) {
        int[] answers1 = {1,2,3,4,5};
        int[] answers2 = {1,3,2,4,2};

        System.out.println(Arrays.toString(solution(answers1)));
        System.out.println(Arrays.toString(solution(answers2)));

    }

    public static int[] solution(int[] answers) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        int[] answer;

        int[] stu1 = {1,2,3,4,5}; // 5
        int[] stu2 = {2,1,2,3,2,4,2,5}; // 8
        int[] stu3 = {3,3,1,1,2,2,4,4,5,5}; // 10

        int[] alist = {0,0,0,0};

        int n = answers.length;

        int count1 = 0;
        int count2 = 0;
        int count3 = 0;

        for(int i = 0; i < n; i++)
        {
            if(answers[i] == stu1[count1]) alist[1] += 1;
            if(answers[i] == stu2[count2]) alist[2] += 1;
            if(answers[i] == stu3[count3]) alist[3] += 1;

            count1 += 1;
            count2 += 1;
            count3 += 1;

            if(count1 == 5) count1 = 0;
            if(count2 == 8) count2 = 0;
            if(count3 == 10) count3 = 0;
        }

        int maxnum = Arrays.stream(alist).max().getAsInt();

        for(int i = 1; i < 4; i++)
        {
            if(alist[i] == maxnum) a.add(i);
        }

        answer = new int[a.size()];

        for(int i = 0; i < a.size(); i++) answer[i] = a.get(i);

        return answer;
    }

}
