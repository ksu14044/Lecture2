package Solutions;

import java.util.*;
class 집을짓자 {
    int[] dx = {0, -1, 0, 1};
    int[] dy = {1, 0, -1, 0};
//    public int solution(int[][] board){
//        int answer = Integer.MAX_VALUE;
//        int idx = 0;
//        int n = board.length;
//        Queue<int[]> q = new LinkedList<>();
//        int[][] dist = new int[n][n];
//        for(int i = 0 ; i < n ; i++){
//            for(int j =0 ; j < n ; j++){
//                if(board[i][j] == 1){
//                    q.offer(new int[]{i, j, idx++});
//                }
//            }
//        }
//        boolean[][][] ch = new boolean[n][n][idx];
//        int L = 0;
//        while(!q.isEmpty()){
//            int len = q.size();
//            L++;
//            for(int i = 0 ; i < len ; i++){
//                int[] cur = q.poll();
//                int x = cur[0], y = cur[1], num = cur[2];
//                for(int d = 0 ; d < 4 ; d++){
//                    int nx = x + dx[d];
//                    int ny = y + dy[d];
//                    if(nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 0 && !ch[nx][ny][num]){
//                        q.offer(new int[]{nx, ny, num});
//                        ch[nx][ny][num] = true;
//                        dist[nx][ny] += L;
//                    }
//                }
//            }
//        };
//        for(int i = 0 ; i < n ; i++){
//            for(int j = 0 ; j < n ; j++){
//                boolean flag = true;
//                for(int k = 0 ; k < idx ; k++){
//                    if(!ch[i][j][k]) flag = false;
//                }
//                if(flag) {
//                    answer = Math.min(answer, dist[i][j]);
//                }
//            }
//        }
//
//        return answer == Integer.MAX_VALUE ? -1 : answer;
//    }

    public int solution(int[][] board){
        int answer = Integer.MAX_VALUE;
        int n = board.length;
        int[][] dist = new int[n][n];
        int emptyLand = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(board[i][j] == 1){
                    bfs(board, dist, i, j, emptyLand, new boolean[n][n]);
                    emptyLand--;
                }
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(board[i][j] == emptyLand){
                    answer = Math.min(answer, dist[i][j]);
                }
            }
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    public void bfs(int[][] board, int[][] dist, int startX, int startY, int emptyLand, boolean[][] ch){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX, startY});
        ch[startX][startY] = true;
        int n = board.length;
        int L = 0;
        while(!q.isEmpty()){
            int len = q.size();
            L++;
            for(int i = 0 ; i < len ; i++){
                int[] cur = q.poll();
                int x = cur[0], y = cur[1];
                for(int d = 0 ; d < 4 ; d++){
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if(nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == emptyLand){
                        q.offer(new int[]{nx, ny});
                        dist[nx][ny] += L;
                        board[nx][ny]--;
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        집을짓자 T = new 집을짓자();
        System.out.println(T.solution(new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 2, 1, 0, 0}, {2, 0, 0, 2, 2}, {0, 0, 0, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 2, 0, 0}, {0, 0, 1, 2}, {0, 2, 0, 0}, {0, 2, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 1}}));
    }
}
