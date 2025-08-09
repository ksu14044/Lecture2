package Solutions;

import java.util.*;
class 좌석번호 {
//    int[] dx = {0, 1, 0, -1};
//    int[] dy = {1, 0,-1, 0};
//    public int[] solution(int c, int r, int k){
//        if(k > r * c ) return new int[]{0, 0};
//        int cnt = 1;
//        int x = 1, y = 1, d = 0;
//        boolean[][] visited = new boolean[r + 1][c + 1];
//        visited[y][x] = true;
//        while(cnt < k){
//            cnt++;
//            int nx = x + dx[d];
//            int ny = y + dy[d];
//            if(nx < 1 || nx > c || ny < 1 || ny > r || visited[ny][nx]){
//                d = (d + 1) % 4;
//                nx = x + dx[d];
//                ny = y + dy[d];
//            }
//            visited[ny][nx] = true;
//            x = nx;
//            y = ny;
//        }
//        return new int[]{x, y};
//    }

    // 왼쪽 아래가 (0,0) 이면 불편하니까 시계방향으로 90도 회전
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    public int[] solution(int c, int r, int k){
        if(k > r * c ) return new int[]{0, 0};
        int[][] seat = new int[c][r];
        int x = 0, y = 0, cnt = 1, d = 0;
        seat[x][y] = cnt;
        while(cnt < k){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx < 0 || nx >= c || ny < 0 || ny >= r || seat[nx][ny] > 0){
                d = (d + 1) % 4;
                continue;
            }
            seat[x][y] = cnt++;
            x = nx;
            y = ny;
        }
        return new int[]{x + 1, y + 1};
    }

    public static void main(String[] args){
        좌석번호 T = new 좌석번호();
        System.out.println(Arrays.toString(T.solution(6, 5, 12)));
        System.out.println(Arrays.toString(T.solution(6, 5, 20)));
        System.out.println(Arrays.toString(T.solution(6, 5, 30)));
        System.out.println(Arrays.toString(T.solution(6, 5, 31)));
    }
}
