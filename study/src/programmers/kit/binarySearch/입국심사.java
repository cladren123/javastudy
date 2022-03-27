package programmers.kit.binarySearch;

public class 입국심사 {

    public static void main(String[] args) {




    }


    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;

        long start = 0;
        long end = Long.MAX_VALUE;
        long mid;
        long sum;

        // start가 end보다 커지면 while문을 종료한다.
        while(start <= end)
        {
            sum = 0;
            mid = (start + end) / 2;

            for(int i = 0; i < times.length; i++)
            {
                sum += mid / times[i];

                if(sum > n)
                    break;
            }

            // 시작을 땡겨오는 것을 중심으로 if문을 구성
            if(sum < n)
            {
                start = mid + 1;
            }
            else
            {
                end = mid - 1;
                answer = Math.min(answer, mid);
            }
        }


        return answer;
    }


}
