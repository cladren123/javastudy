package programmers.level2.page4;

public class N개의최소공배수 {

    public static void main(String[] args) {

        int[] arr1 = {2,6,8,14};
        int[] arr2 = {1,2,3};

        System.out.println(solution(arr1));
        System.out.println(solution(arr2));

    }

    public static int solution(int[] arr) {
        int answer = arr[0];

        int n = arr.length;

        for(int i = 0; i < n; i++)
        {
            answer = lcm(answer, arr[i]);
        }


        return answer;
    }


    // 유클리드 호제법 : 최대공약수를 찾는 함수
    public static int gcd(int a, int b)
    {
        while(b != 0)
        {
            int r = a%b;
            a = b;
            b = r;
        }
        return a;
    }

    // 최소공배수 : a * b / 최대공약수
    public static int lcm(int a, int b)
    {
        return a*b/gcd(a,b);
    }

}
