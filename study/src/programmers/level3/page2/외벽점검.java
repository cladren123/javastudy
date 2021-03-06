package programmers.level3.page2;

public class 외벽점검 {

    public int n, min;
    public int[] weak, dist;
    public int[][] rotateWeak;
    public boolean[] visit;

    public int solution(int n, int[] weak, int[] dist) {
        this.n = n;
        this.weak = weak;
        this.dist = dist;


        rotateWeak = new int[weak.length][weak.length];


        visit = new boolean[dist.length];
        min = Integer.MAX_VALUE;


        rotate();

        for(int i = 1; i <= dist.length; i++) {
            per(0, i, "");
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    // weak 점들을 시작점으로 배열로 구성
    // n = 12
    // 1 5 6 10
    // 5 6 10 13
    // 6 10 13 17
    // 10 13 17 18
    public void rotate() {
        for(int j = 0; j < weak.length; j++) {
            int ro[] = new int[weak.length];
            int index = j;

            for(int i = 0; i < weak.length; i++) {
                ro[i] = weak[index % weak.length];

                if(index >= weak.length)
                    ro[i] += n;
                index++;
            }
            rotateWeak[j] = ro;
        }
    }

    // 탐색할 dist의 경우의 수를 구한다.
    public void per(int count, int length, String s) {
        if(count == length) {
            check(s.trim().split(" "));
            return;
        }

        for(int i = 0; i < dist.length; i++) {
            if(!visit[i]) {
                visit[i] = true;
                per(count+1, length, s + dist[i]+ " ");
                visit[i] = false;
            }
        }
    }



    public void check(String s[]) {

        // 추린 대상을 people에 옮긴다.
        int people[] = new int[s.length];
        for(int i = 0; i < s.length; i++)
            people[i] = Integer.parseInt(s[i]);

        // rotateweak을 돌려
        for(int i = 0; i < rotateWeak.length; i++) {

            int index = 0;
            int start = rotateWeak[i][index];

            // 사람을 돌려
            for(int j = 0; j < people.length; j++) {

                //
                while(index < rotateWeak.length && rotateWeak[i][index]-start <= people[j]) {
                    index++;
                }
                // 정답조건 : 대기자가 취약지점보다 많으면 정답으로 처리한다.
                if(index >= rotateWeak.length)
                    min = Math.min(min, people.length);
                else
                    start = rotateWeak[i][index];
            }
        }
    }

}
