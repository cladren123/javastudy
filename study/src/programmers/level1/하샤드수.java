package programmers.level1;

public class 하샤드수 {

    public static void main(String[] args) {

        int arr1 = 10;
        int arr2 = 12;
        int arr3 = 11;
        int arr4 = 13;

        System.out.println(solution(arr1));
        System.out.println(solution(arr2));
        System.out.println(solution(arr3));
        System.out.println(solution(arr4));

    }

    public static boolean solution(int x) {
        boolean answer = true;

        int sumnum = 0;

        int x1 = x;

        while(x1 >= 10)
        {
            sumnum += x1 % 10;
            x1 = (int)(x1 / 10);
        }

        sumnum += x1;

        if(x % sumnum != 0) answer = false;

        return answer;
    }
}
