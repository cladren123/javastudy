package programmers.level3.page1;

// 2:25 시작
// map으로 풀었는데 dfs로 풀어야 될거 같다..
// String key의 중복이 발생하기 때문에

// 2번째 풀이 dfs와 HashSet을 사용
// dfs를 통해 조건에 맞는 것들을 탐색해 모든 경우의 수르 구한다.
// HashSet을 이용해 중복을 제거한다.

import java.util.*;

public class 불량사용자 {

    public static void main(String[] args) {

        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "abc1**"};

        System.out.println(solution(user_id, banned_id));

    }

    static String[] store; // 저장소
    static boolean[] visited; // 마킹여부
    static HashSet<String> set;
    static int n;
    static int m;
    static int answer;

    public static int solution(String[] user_id, String[] banned_id) {
        answer = 0;

        n = user_id.length;
        m = banned_id.length;

        store = new String[m];
        visited = new boolean[n];

        set = new HashSet<>();

        dfs(0, user_id, banned_id);


        answer = set.size();

        return answer;
    }

    public static void dfs(int stage, String[] userid, String[] bannedid)
    {

        // 종단조건
        if(stage == m)
        {
            String[] newstore = new String[m];
            for(int i = 0; i < m; i++)
                newstore[i] = store[i];

            Arrays.sort(newstore);

            String one = "";
            for(int i = 0; i < m; i++)
                one += newstore[i];

            set.add(one);

            return;
        }

        for(int i = 0; i < n; i++)
        {
            // 한 번도 마킹이 되지 않았다면
            if(visited[i] == false)
            {
                // 비교
                String user = userid[i];
                String ban = bannedid[stage];

                int count = 0;
                if(user.length() == ban.length())
                {
                    for(int k = 0; k < user.length(); k++)
                    {
                        if(ban.charAt(k) == '*')
                            count += 1;
                        else if(ban.charAt(k) == user.charAt(k))
                            count += 1;
                    }

                    if(count == user.length())
                    {
                        visited[i] = true;
                        store[stage] = user;
                        dfs(stage + 1, userid, bannedid);
                        visited[i] = false;
                    }

                }




            }


        }

    }


}
