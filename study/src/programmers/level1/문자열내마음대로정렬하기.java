package programmers.level1;

import java.util.*;


public class 문자열내마음대로정렬하기 {

    public static void main(String[] args) {

        String[] strings1 = {"sun", "bed", "car"};
        int n1 = 1;

        String[] strings2 = {"abce", "abcd", "cdx"};
        int n2 = 2;

        System.out.println(Arrays.toString(solution(strings1, n1)));
        System.out.println(Arrays.toString(solution(strings2, n2)));

    }

    public static String[] solution(String[] strings, int n) {
        String[] answer = {};

        ArrayList<String> store = new ArrayList<String>();

        int m = strings.length;

        for(int i = 0; i < m; i++)
        {
            String one = strings[i].charAt(n) + strings[i];
            store.add(one);
        }

        Collections.sort(store);

        answer = new String[m];

        for(int i = 0; i < m; i++)
        {
            answer[i] = store.get(i).substring(1, store.get(i).length());
        }


        return answer;
    }

}
