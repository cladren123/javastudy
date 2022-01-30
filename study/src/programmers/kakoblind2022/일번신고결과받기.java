package programmers.kakoblind2022;

import java.util.*;

public class 일번신고결과받기 {

    public static void main(String[] args) {

        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        System.out.println(Arrays.toString(solution(id_list, report, k)));

    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};

        answer = new int[id_list.length];

        HashMap<String,HashSet<String>> person = new HashMap<>(); // 신고한 사람 목록
        HashMap<String,Integer> count = new HashMap<>(); // 횟수저장

        for(String one : report)
        {
            String[] sp = one.split(" ");

            String repoter = sp[0];
            String repoted = sp[1];

            if(person.containsKey(repoter) && person.get(repoter).contains(repoted))
            {

            }
            else
            {
                count.put(repoted, count.getOrDefault(repoted, 0) + 1);
            }


            if(person.containsKey(repoter))
            {
                person.get(repoter).add(repoted);
            }
            else
            {
                HashSet<String> temp = new HashSet<>();
                temp.add(repoted);
                person.put(repoter, temp);
            }

        }

        for(int i = 0; i < id_list.length; i++)
        {
            String one = id_list[i];

            if(person.containsKey(one))
            {
                for(String per : person.get(one))
                {
                    if(count.get(per) >= k)
                        answer[i] += 1;
                }
            }




        }


        return answer;
    }


}
