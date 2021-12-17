package programmers.level2.page1;

import java.util.*;

public class 오픈채팅방 {

    public static void main(String[] args) {

        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo",
                "Leave uid1234","Enter uid1234 Prodo",
                "Change uid4567 Ryan"};

        System.out.println(Arrays.toString(solution(record)));

    }

    public static String[] solution(String[] record) {
        String[] answer = {};

        int n = record.length;
        int count = 0;

        String nickname = "";

        Map<String, String> map = new HashMap<String, String>();
        ArrayList<String> saverecord = new ArrayList<String>();

        for(String caseone : record)
        {
            int m = caseone.length();
            StringTokenizer st = new StringTokenizer(caseone, " ");
            String inout = st.nextToken();
            String id = st.nextToken();
            if(!inout.equals("Leave"))
            {
                nickname = st.nextToken();
                map.put(id, nickname);
            }

            count += 1;

            if(inout.equals("Change")) continue;

            String make1 = inout + " " + id;
            saverecord.add(make1);

        }


        int m = saverecord.size();
        answer = new String[m];

        for(int i = 0; i < m; i++)
        {
            StringTokenizer st = new StringTokenizer(saverecord.get(i), " ");
            String inout = st.nextToken();
            String id = st.nextToken();

            if(inout.equals("Enter")) answer[i] = map.get(id) + "님이 들어왔습니다.";
            else if(inout.equals("Leave")) answer[i] = map.get(id) + "님이 나갔습니다.";
        }

        return answer;
    }


}
