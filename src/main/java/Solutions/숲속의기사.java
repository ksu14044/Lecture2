package Solutions;


import java.util.*;
class 숲속의기사 {
    int[] dx = {0, -1, 0, 1};
    int[] dy = {1, 0, -1, 0};
    public int solution(int[][] board){
        int answer = Integer.MAX_VALUE;
        int r = board.length;
        int c = board[0].length;
        int[][] dist = new int[r][c];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0 ; i < r ; i++){
            for(int j = 0 ; j < c ; j++){
                if(board[i][j] == 2 || board[i][j] == 3){
                    int[][] ch = new int[r][c];
                    q.offer(new int[]{i, j, 1});
                    ch[i][j] = 1;
                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        int x = cur[0], y = cur[1], cnt = cur[2];
                        for(int d = 0 ; d < 4 ; d++){
                            int nx = x + dx[d];
                            int ny = y + dy[d];
                            if(nx >= 0 && nx < r && ny >= 0 && ny < c && board[nx][ny] != 1 && ch[nx][ny] == 0){
                                q.offer(new int[]{nx, ny, cnt + 1});
                                dist[nx][ny] += cnt;
                                ch[nx][ny] = 1;
                            }
                        }
                    }
                }
            }
        }
        for(int i = 0 ; i < r ; i++){
            for(int j = 0 ; j < c ; j++){
                if(board[i][j] == 4 && dist[i][j] > 0){
                    answer = Math.min(answer, dist[i][j]);
                }
            }
        }
        return answer;
    }


    public static void main(String[] args){
        숲속의기사 T = new 숲속의기사();
        System.out.println(T.solution(new int[][]{
                {4, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 0},
                {0, 2, 1, 1, 3, 0, 4, 0},
                {0, 0, 0, 4, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{
                {3, 0, 0, 0, 1, 4, 4, 4},
                {0, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 4, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 1, 1, 0},
                {4, 0, 0, 0, 1, 0, 0, 0},
                {4, 1, 0, 0, 1, 0, 0, 0},
                {4, 0, 0, 0, 0, 0, 1, 2}}));
        System.out.println(T.solution(new int[][]{
                {4, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 2, 3, 4},
                {0, 1, 0, 1, 0}}));
    }
}