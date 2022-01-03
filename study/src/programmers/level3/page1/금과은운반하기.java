package programmers.level3.page1;

public class 금과은운반하기 {

    public static void main(String[] args) {

        int a = 10;
        int b = 10;
        int[] g = {100};
        int[] s = {100};
        int[] w = {7};
        int[] t = {10};

        System.out.println(solution(a,b,g,s,w,t));

    }

    public static long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {


        long answer = (long)(1e5 * 4 * 1e9);
        long start = 0;
        long end = (long)(1e5 * 4 * 1e9);

        while(start <= end)
        {
            long mid = (start + end) / 2;
            long gold = 0;
            long silver = 0;
            long add = 0;

            for(int i = 0; i < s.length; i++)
            {
                long nowg = g[i];
                long nows = s[i];
                long noww = w[i];
                long nowt = t[i];

                long movecount = mid / (nowt * 2);

                if(mid % (nowt * 2) >= t[i]) movecount++;

                gold += (nowg < movecount * noww) ? nowg : movecount * noww;
                silver += (nows < movecount * noww) ? nows : movecount * noww;
                add += (nowg + nows < movecount * noww) ? nowg + nows : movecount * noww;


            }

            if(gold >= a && silver >= b && add >= a + b)
            {
                end = mid - 1;
                answer = Math.min(mid, answer);
            }
            else
            {
                start = mid + 1;
            }


        }





        return answer;
    }


}
