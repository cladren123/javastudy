package programmers.level2.threepage;

public class 스킬트리 {

    public static void main(String[] args) {

        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};

        System.out.println(solution(skill, skill_trees));

    }

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        int n = skill_trees.length;

        int m = skill.length();

        // 선행 조건이 만족하지 않는 경우
        // 먼저 나온 경우
        // 건너 띈 경우

        for(int i = 0; i < n; i++)
        {
            String one = skill_trees[i];
            int onen = one.length();

            // 스킬순서를 skill에 있지 않는 것을 모두 지운다.
            // 순서가 맞으면 정답이다.

            String sort = "";

            for(int j = 0; j < onen; j++)
            {
                for(int k = 0; k < m; k++)
                {
                    if(one.charAt(j) == skill.charAt(k))
                        sort += one.charAt(j);
                }
            }



            int sortn = sort.length();
            int flag = 1;

            for(int j = 0; j < sortn; j++)
            {
                if(sort.charAt(j) != skill.charAt(j))
                {
                    flag = 0;
                    break;
                }
            }

            if(flag == 1)
            {
                answer += 1;
            }

        }

        return answer;
    }

}
