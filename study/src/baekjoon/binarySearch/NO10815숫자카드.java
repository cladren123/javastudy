package baekjoon.binarySearch;

import java.util.*;
import java.lang.*;
import java.io.*;

public class NO10815숫자카드 {

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] cards = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++)
            cards[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(cards);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] checker = new int[m];
        for(int i = 0; i < m; i++)
            checker[i] = Integer.parseInt(st.nextToken());

        int[] answer = new int[m];

        for(int i = 0 ; i < m; i++)
        {
            answer[i] = binarySearch(checker[i], cards);
        }

        for(int i = 0; i < m; i++)
            System.out.print(answer[i] + " ");

    }

    // 이분탐색
    public static int binarySearch(int target, int[] arr)
    {
        int n = arr.length;

        int start = 0;
        int end = n - 1;
        int mid;

        while(start <= end)
        {
            mid = (start + end) / 2;

            // 타겟이 맞으면 1을 반환한다.
            if(arr[mid] == target)
                return 1;
            else if(arr[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }

        return 0;

    }

}
