package programmers.level3.page3;

import java.util.*;

public class NQueen {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(solution(n));

    }

    static ArrayList<int[]> store;
    static int answer;
    static int n;

    public static int solution(int n1) {

        answer = 0;
        n = n1;
        store = new ArrayList<>();
        dfs(0);

        return answer;
    }

    public static void dfs(int stage)
    {
        if(stage == n)
        {
            answer += 1;

//             for(int i = 0; i < n; i++)
//                 System.out.println(Arrays.toString(store.get(i)));

//             System.out.println();

            return;
        }

        for(int i = 0; i < n; i++)
        {
            // 처음에는 조건 따지지 않고 집어 넣는다.
            if(stage==0)
            {
                int[] one = new int[2];
                one[0] = stage;
                one[1] = i;
                store.add(one);
                dfs(stage+1);
                store.remove(one);
            }
            else if(stage>=1)
            {
                int[] two = new int[2];
                two[0] = stage;
                two[1] = i;

                int flag = 1;
                for(int j = 0; j < store.size(); j++)
                {
                    // 위쪽 확인
                    if(two[1] == store.get(j)[1])
                    {
                        flag = 0;
                        break;
                    }

                    // 대각선 확인
                    if( Math.abs(two[0] - store.get(j)[0]) == Math.abs(two[1] - store.get(j)[1]))
                    {
                        flag = 0;
                        break;

                    }

                }

                if(flag==1)
                {
                    store.add(two);
                    dfs(stage+1);
                    store.remove(two);
                }

            }

        }


    }
}
