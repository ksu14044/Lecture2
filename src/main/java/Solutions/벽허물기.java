package Solutions;

import java.util.*;
class 벽허물기 {
//    public int solution(int[][] board) {
//        int answer = 0;
//        int n = board.length;
//        int m = board[0].length;
//        int[] dx = {0, -1, 0, 1};
//        int[] dy = {1, 0, -1, 0};
//        Queue<int[]> q = new LinkedList<>();
//        boolean[][] ch = new boolean[n][m];
//        q.offer(new int[]{0, 0});
//        ch[0][0] = true;
//        int L = 0;
//        while(!q.isEmpty()){
//            List<int[]> walls = new ArrayList<>();
//            while(!q.isEmpty()){
//                int len = q.size();
//                for(int i = 0 ; i < len ; i++){
//                    int[] cur = q.poll();
//                    int x = cur[0], y = cur[1];
//                    if( x == n - 1 && y == m - 1) return L;
//                    for(int d = 0 ; d < 4 ; d++){
//                        int nx = x + dx[d];
//                        int ny = y + dy[d];
//                        if(nx >= 0 && nx < n && ny >= 0 && ny < m && !ch[nx][ny]){
//                            if(board[nx][ny] == 0){
//                                q.offer(new int[]{nx, ny});
//                                ch[nx][ny] = true;
//                            } else if(board[nx][ny] == 1){
//                                walls.add(new int[]{nx, ny});
//                            }
//                        }
//                    }
//                }
//            }
//            for(int[] wall : walls){
//                q.offer(wall);
//                ch[wall[0]][wall[1]] = true;
//            }
//            L++;
//        }
//
//        return answer;
//    }

    public int solution(int[][] board){
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, 0});
        int n = board.length;
        int m = board[0].length;
        int[][] costs = new int[n][m];
        for(int[] c : costs) Arrays.fill(c, Integer.MAX_VALUE);
        costs[0][0] = 0;
        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};
        while(!pq.isEmpty()){
            int len = pq.size();
            for(int i = 0 ; i < len ; i++){
                int[] cur = pq.poll();
                int x = cur[0], y = cur[1], cost = cur[2];
                if(cost > costs[x][y]) continue;
                for(int d = 0 ; d < 4; d++){
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if(nx >= 0 && nx < n && ny >= 0 && ny < m){
                        if(board[nx][ny] == 0){
                            if(costs[nx][ny] > cost){
                                costs[nx][ny] = cost;
                                pq.offer(new int[]{nx, ny, cost});
                            }
                        } else if(board[nx][ny] == 1){
                            if(costs[nx][ny] > cost + 1){
                                costs[nx][ny] = cost + 1;
                                pq.offer(new int[]{nx, ny, cost + 1});
                            }
                        }
                    }
                }
            }
        }

        return costs[n - 1][m - 1];
    }


    public static void main(String[] args){
        벽허물기 T = new 벽허물기();
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0}, {1, 0, 0, 1}, {0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{
                {0, 1, 1, 0},
                {1, 1, 0, 1},
                {0, 0, 1, 0},
                {0, 1, 1, 1},
                {0, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1},{0, 1, 1, 1, 1, 1},{1, 0, 0, 0, 1, 1}, {1, 1, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 0}, {1, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 0, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 1, 1, 1},{1, 1, 0, 0, 1, 1, 1},{1, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 1, 1}, {1, 0, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 0, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 1, 0}}));
    }
}
