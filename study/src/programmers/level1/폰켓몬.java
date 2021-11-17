package programmers.level1;

import java.util.*;
import java.lang.*;
import java.io.*;

public class 폰켓몬 {

    public static void main(String[] args) {

        int[] nums1 = {3,1,2,3};
        int[] nums2 = {3,3,3,2,2,4};
        int[] nums3 = {3,3,3,2,2,2};

        System.out.println(solution(nums1));
        System.out.println(solution(nums2));
        System.out.println(solution(nums3));

    }

    public static int solution(int[] nums) {
        int answer = 0;

        int n = nums.length / 2;

        ArrayList<Integer> array = new ArrayList<Integer>();

        for(int i : nums)
        {
            if(!array.contains(i)) array.add(i);
        }

        int m = array.size();

        answer = Math.min(n,m);


        return answer;
    }


}
