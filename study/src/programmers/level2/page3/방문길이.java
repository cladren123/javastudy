package programmers.level2.page3;

public class 방문길이 {

    public static void main(String[] args) {

        String dirs1 = "ULURRDLLU";
        String dirs2 = "LULLLLLLU";

        System.out.println(dirs1);
        System.out.println(dirs2);

    }

    public static int solution(String dirs) {

        // 8~20 실패 : 되돌아가는 부분을 구현 안함

        int answer = 0;

        // 판
        int[][] board = new int[11][11];

        // 경로 표시
        int[][][][] visited = new int[11][11][11][11];

        // R D L U 순서
        int[] dx = {1,0,-1,0};
        int[] dy = {0,-1,0,1};

        int y = 5;
        int x = 5;

        int n = dirs.length();

        int index = 0;

        for(int i = 0; i < n; i++)
        {
            char one = dirs.charAt(i);

            // 처음위치와 이동할 위치를 저장, 선이기 때문에

            if(one == 'R')
                index = 0;
            else if(one == 'D')
                index = 1;
            else if(one == 'L')
                index = 2;
            else if(one == 'U')
                index = 3;

            int ny = y + dy[index];
            int nx = x + dx[index];

            int flag = 0;

            if(ny < 0) {
                ny = 0;
                flag = 1;
            }
            if(nx < 0){
                nx = 0;
                flag = 1;
            }
            if(ny > 10){
                ny = 10;
                flag = 1;
            }
            if(nx > 10){
                nx = 10;
                flag = 1;
            }

            if(visited[y][x][ny][nx] == 0 && flag == 0)
            {
                answer += 1;
            }

            visited[y][x][ny][nx] = 1;
            visited[ny][nx][y][x] = 1;

            y = ny;
            x = nx;

        }

        return answer;
    }


}
