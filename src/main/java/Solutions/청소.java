package Solutions;

import java.util.*;
class 청소 {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    public int[] solution(int[][] board, int k){

        int x = 0, y = 0, time = 0, dir = 0;
        int n = board.length;
        while(time < k){
            time++;
            int nx = x + dx[dir % 4];
            int ny = y + dy[dir % 4];
            if(nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1) {
                dir++;
                continue;
            }
            x = nx;
            y = ny;
        }
        return new int[]{x, y};
    }

    public static void main(String[] args){
        청소 T = new 청소();
        int[][] arr1 = {{0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr1, 10)));
        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr2, 20)));
        int[][] arr3 = {{0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr3, 25)));

    }
}