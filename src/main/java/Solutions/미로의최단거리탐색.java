package Solutions;

import java.util.*;
class 미로의최단거리탐색 {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
//    public int solution(int[][] board){
//        int answer = 0;
//        Queue<int[]> q = new LinkedList<>();
//        boolean[][] visited = new boolean[7][7];
//        q.offer(new int[]{0, 0});
//        visited[0][0] = true;
//        int L = 0;
//        while(!q.isEmpty()){
//            int len = q.size();
//            for(int i = 0 ; i < len ; i++){
//                int[] cur = q.poll();
//                if(cur[0] == 6 && cur[1] == 6) return L;
//                for(int d = 0 ; d < 4 ; d++){
//                    int nx = cur[0] + dx[d];
//                    int ny = cur[1] + dy[d];
//                    if(nx < 0 || nx >= 7 || ny < 0 || ny >= 7|| visited[nx][ny] || board[nx][ny] == 1) continue;
//                    q.offer(new int[]{nx, ny});
//                    visited[nx][ny] = true;
//                }
//            }
//            L++;
//        }
//        return -1;
//    }
    public int solution(int[][] board){
        int answer = 0;
        int[][] dist = new int[7][7];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        int L = 0;
        board[0][0] = 1;
        while(!q.isEmpty()){
            L++;
            for(int i = 0 ; i < q.size() ; i++){
                int[] cur = q.poll();
                int x = cur[0], y = cur[1];
                for(int d = 0 ; d < 4 ; d++){
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if(nx < 0 || nx >= 7 || ny < 0 || ny >= 7 || board[nx][ny] == 1) continue;
                    q.offer(new int[]{nx, ny});
                    dist[nx][ny] = L;
                    board[nx][ny] = 1;
                }
            }
        }
        return dist[6][6] == 0 ? -1 : dist[6][6];
    }

    public static void main(String[] args){
        미로의최단거리탐색 T = new 미로의최단거리탐색();
        int[][] arr={{0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 0, 0, 0}};
        System.out.println(T.solution(arr));
    }
}
