package Solutions;

import java.util.*;
class 비밀번호 {
    int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
    int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};
//    public int solution(int[] keypad, String password){
//        int answer = 0;
//        int[][] board = new int[3][3];
//        for(int i = 0 ; i < keypad.length ; i++){
//            int r = i / 3;
//            int c = i % 3;
//            board[r][c] = keypad[i];
//        }
//        int[] pw = new int[password.length()];
//        for(int i = 0 ; i < password.length() ; i++){
//            pw[i] = (int)password.charAt(i) - '0';
//        }
//        int[] start = find(board, pw[0]);
//        int x = start[0], y = start[1];
//        for(int i = 1 ; i < pw.length ; i++){
//            int[] cur = find(board, pw[i]);
//            int curX = cur[0], curY = cur[1];
//            boolean isNear = false;
//            if(x == curX && y == curY) continue;
//            for(int d = 0 ; d < 8 ; d++){
//                int nx = x + dx[d];
//                int ny = y + dy[d];
//                if(nx == curX && ny == curY){
//                    isNear = true;
//                }
//            }
//            if(isNear){
//                answer++;
//            } else answer += 2;
//            x = curX; y = curY;
//        }
//        return answer;
//    }

    public int solution(int[] keypad, String password){
        int[][] pad = new int[3][3];
        for(int i = 0 ; i < keypad.length ; i++){
            int r = i / 3;
            int c = i % 3;
            pad[r][c] = keypad[i];
        }
        int[][] dist = new int[10][10];

        for(int i = 0 ; i < 10 ; i++){
            Arrays.fill(dist[i], 2);
            dist[i][i] = 0;
        }

        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                int cur = pad[i][j];
                for(int d = 0 ; d < 8 ; d++){
                    int ni = i + dx[d];
                    int nj = j + dy[d];
                    if(ni < 3 && ni >= 0 && nj < 3 && nj >= 0){
                        int next = pad[ni][nj];
                        dist[cur][next] = 1;
                    }
                }
            }
        }
        int answer = 0;
        for(int i = 0 ; i < password.length() - 1 ; i++){
            int from = (int)password.charAt(i) - '0';
            int to = (int)password.charAt(i + 1) - '0';
            answer += dist[from][to];
        }
        return answer;
    }

    public int[] find(int[][] board, int target){
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[i].length ; j++){
                if(board[i][j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args){
        비밀번호 T = new 비밀번호();
        System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
    }
}
