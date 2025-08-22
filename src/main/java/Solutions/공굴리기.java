package Solutions;

import java.util.*;
class 공굴리기 {
//    public int solution(int[][] board, int[] s, int[] e){
//        int answer = 0;
//        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]);
//        q.offer(new int[]{s[0], s[1], 0});
//        int n = board.length;
//        int m = board[0].length;
//        boolean[][] ch = new boolean[n][m];
//        int[] dx = {0, -1, 0, 1};
//        int[] dy = {1, 0, -1, 0};
//        while(!q.isEmpty()){
//            int len = q.size();
//            for(int i = 0 ; i < len ; i++){
//                int[] cur = q.poll();
//                int x = cur[0], y = cur[1], cnt = cur[2];
//                if(x == e[0] && y == e[1]) return cnt;
////                System.out.println("x : " + x + " y : " + y + " cnt : " + cnt);
//                for(int d = 0 ; d < 4 ; d++){
//                    int nx = x;
//                    int ny = y;
//                    boolean flag = false;
//                    int tmp = cnt;
//                    while(nx + dx[d] >= 0 && nx + dx[d] < n && ny + dy[d] >= 0 && ny + dy[d] < m && board[nx + dx[d]][ny + dy[d]] == 0){
//                        nx += dx[d];
//                        ny += dy[d];
//                        tmp++;
//                        flag = true;
//                    }
////                    System.out.println("nx : " + nx + " ny : " + ny);
//                    if(flag){
//                        if(!ch[nx][ny]){
//                            ch[nx][ny] = true;
//                            q.offer(new int[]{nx, ny, tmp});
//                        }
//                    }
//                }
//            }
//        }
//        return -1;
//    }

    public int solution(int[][] board, int[] s, int[] e){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{s[0], s[1], 0});
        int n = board.length;
        int m = board[0].length;
        int[][] cost = new int[n][m];
        for(int[] c : cost) Arrays.fill(c, Integer.MAX_VALUE);
        cost[s[0]][s[1]] = 0;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(cur[2] > cost[cur[0]][cur[1]]) continue;
            for(int i = 0 ; i < 4 ; i++){
                int nx = cur[0];
                int ny = cur[1];
                int len = cur[2];
                while(nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0){
                    nx += dx[i];
                    ny += dy[i];
                    len++;
                }
                nx -= dx[i];
                ny -= dy[i];
                len--;
                if(cost[nx][ny] > len){
                    cost[nx][ny] = len;
                    pq.offer(new int[]{nx, ny, len});
                }
            }
        }
        return cost[e[0]][e[1]] == Integer.MAX_VALUE ? -1 : cost[e[0]][e[1]];
    }

    public static void main(String[] args){
        공굴리기 T = new 공굴리기();
        System.out.println(T.solution(new int[][]{
                {0, 0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0},
                {1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 0}}, new int[]{1, 0}, new int[]{4, 5}));
        System.out.println(T.solution(new int[][]{
                {0, 0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0},
                {1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 2}));
        System.out.println(T.solution(new int[][]{
                {1, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}}, new int[]{0, 3}, new int[]{4, 2}));
        System.out.println(T.solution(new int[][]{{0, 1, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 5}));
        System.out.println(T.solution(new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 3}));
    }
}

