package Solutions;

import java.util.*;
class 방향바꾸기 {
    public int solution(int[][] board) {
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int n = board.length;
        int m = board[0].length;
        int[] dx = {-1, 0, 0, 1, -1};
        int[] dy = {-1, 1, -1, 0, 0};
        int[][] costs = new int[n][m];
        for(int[] c : costs) Arrays.fill(c, Integer.MAX_VALUE);
        costs[n-1][m-1] = 0;
        pq.offer(new int[]{n -1, m - 1, 0});
        while(!pq.isEmpty()){
            int len = pq.size();
            for(int i = 0 ; i < len ; i++){
                int[] cur = pq.poll();
                int x = cur[0], y = cur[1], cost = cur[2];
                for(int d = 1 ; d <= 4 ; d++){
                    int px = x + dx[d];
                    int py = y + dy[d];
                    if(px >= 0 && px < n && py >= 0 && py < m){
                        if(px + dx[board[px][py]] == x && py + dy[board[px][py]] == y && costs[px][py] > cost){
                            costs[px][py] = cost;
                            pq.offer(new int[]{px, py, cost});
                        } else if((px + dx[board[px][py]] != x || py + dy[board[px][py]] != y) && costs[px][py] > cost + 1){
                            costs[px][py] = cost + 1;
                            pq.offer(new int[]{px, py, cost + 1});
                        }
                    }
                }
            }
        }
        return costs[0][0];
    }

    public static void main(String[] args){
        방향바꾸기 T = new 방향바꾸기();
        System.out.println(T.solution(new int[][]{{3, 1, 3}, {1, 4, 2}, {4, 2, 3}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3}, {1, 1, 4, 2}, {3, 4, 2, 1}, {1, 2, 2, 4}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3, 1, 2}, {2, 1, 1, 1, 4, 2}, {2, 2, 2, 1, 2, 2}, {1, 3, 3, 4, 4, 4}, {1, 2, 2, 3, 3, 4}}));
        System.out.println(T.solution(new int[][]{{3, 2, 1, 3, 1, 2, 2, 2}, {2, 1, 1, 1, 4, 2, 1, 1}, {2, 2, 2, 1, 2, 2, 3, 4}, {1, 3, 3, 4, 4, 4, 3, 1}, {1, 2, 2, 3, 3, 4, 3, 4}, {1, 2, 2, 3, 3, 1, 1, 1}}));
        System.out.println(T.solution(new int[][]{{1, 2, 3, 2, 1, 3, 1, 2, 2, 2}, {1, 2, 2, 1, 1, 1, 4, 2, 1, 1}, {3, 2, 2, 2, 2, 1, 2, 2, 3, 4}, {3, 3, 1, 3, 3, 4, 4, 4, 3, 1}, {1, 1, 1, 2, 2, 3, 3, 4, 3, 4}, {1, 1, 1, 2, 2, 3, 3, 1, 1, 1}}));
    }
}
