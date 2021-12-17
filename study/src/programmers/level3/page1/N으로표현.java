package programmers.level3.page1;

import java.util.*;

public class N으로표현 {

    public static void main(String[] args) {

        int N1 = 5;
        int number1 = 12;

        int N2 = 2;
        int number2 = 11;

        System.out.println(solution(N1, number1));
        System.out.println(solution(N2, number2));


    }

    static int origin;
    static HashSet<Integer>[] sets;

    public static int solution(int N, int number) {
        int answer = 0;
        origin = N;
        sets = new HashSet[9];


        for(int i=1; i<=8; i++) {
            getNum(i);
            if(sets[i].contains(number)){
                return i;
            }
        }

        return -1;
    }

    // 단계 채우는 함수
    public static HashSet<Integer> getNum(int n) {
        if(sets[n] != null){
            return sets[n];
        }

        int num = 0;

        // 5, 55, 555 과정
        for(int i=0; i<n ; i++){
            num = 10 * num + origin;
        }

        sets[n] = new HashSet<>();
        sets[n].add(num);

        for(int i=1; i<n; i++) {
            int j = n-i;
            if(sets[i] !=null || sets[j] != null){
                getNum(i);
                getNum(j);
            }
            for(int n1 : sets[i]) {
                for(int n2 : sets[j]) {
                    sets[n].add(n1+n2);
                    sets[n].add(n1-n2);
                    sets[n].add(n1*n2);
                    if(n2!=0) {
                        sets[n].add(n1/n2);
                    }
                }
            }
        }

        return sets[n];

    }


}
