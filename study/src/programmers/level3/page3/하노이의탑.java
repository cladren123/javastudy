package programmers.level3.page3;

import java.util.*;

public class 하노이의탑 {

    public static void main(String[] args) {

        int n = 2;
        System.out.println(Arrays.toString(solution(n)));

    }

    static ArrayList<int[]> list;

    public static int[][] solution(int n) {
        list = new ArrayList<>();
        hanoi(1, 2, 3, n); //n개의 원판을 1에서 시작 -> 2를 거쳐 -> 3으로 옮긴다.
        int[][] result = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++) {
            result[i][0] = list.get(i)[0];
            result[i][1] = list.get(i)[1];
        }
        return result;
    }

    public static void hanoi(int s, int v, int e, int n) {
        int[] move = {s, e};

        if(n == 1) list.add(move);
        else {
            hanoi(s, e, v, n - 1);
            list.add(move);
            hanoi(v, s, e, n - 1);
        }
    }




}
