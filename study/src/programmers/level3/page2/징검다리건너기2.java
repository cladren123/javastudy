package programmers.level3.page2;

public class 징검다리건너기2 {

    public static void main(String[] args) {
        int[] stones = {2,4,5,3,2,1,4,2,5,1};
        int k = 3;

        System.out.println(solution(stones, k));

    }

    public static int solution(int[] stones, int k) {
        int answer = 0;

        int min = 0;
        int max = 200000000;

        while(min <= max)
        {
            int mid = (min + max) / 2;

            if(canCross(mid, stones, k))
            {
                min = mid + 1;
                answer = mid;
            }
            else
            {
                max = mid - 1;
            }
        }


        return answer;
    }

    static boolean canCross(int number, int[] stones, int k)
    {
        int skip = 0;

        for(int stone : stones)
        {
            if(stone < number) skip += 1;
            else skip = 0;

            if(skip == k) return false;
        }

        return true;

    }

}
