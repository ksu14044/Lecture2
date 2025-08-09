package Solutions;

class 잃어버린강아지 {
    public int solution(int[][] board){
        int answer = 0;
        int x1 = 0; int x2 = 0; int y1 = 0; int y2 = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int d1 = 0; int d2 = 0;
        for(int i = 0 ; i < 10 ; i++){
            for(int j = 0 ; j < 10 ; j++){
                if(board[i][j] == 2){
                    x1 = i;
                    y1 = j;
                } else if(board[i][j] == 3){
                    x2 = i;
                    y2 = j;
                }
            }
        }
        while(answer < 10000){
            if(x1 == x2 && y1 == y2){
                return answer;
            }
            answer++;
            int nx1 = x1 + dx[d1 % 4];
            int ny1 = y1 + dy[d1 % 4];
            int nx2 = x2 + dx[d2 % 4];
            int ny2 = y2 + dy[d2 % 4];
            int tmp1 = d1;
            int tmp2 = d2;
            if(nx1 < 0 || nx1 >= 10 || ny1 < 0 || ny1 >= 10 || board[nx1][ny1] == 1){
                d1++;
            }
            if(nx2 < 0 || nx2 >= 10 || ny2 < 0 || ny2 >= 10 || board[nx2][ny2] == 1){
                d2++;
            }
            if(tmp1 == d1){
                x1 = nx1;
                y1 = ny1;
            }
            if(tmp2 == d2){
                x2 = nx2;
                y2 = ny2;
            }
        }
        return 0;
    }

    public static void main(String[] args){
        잃어버린강아지 T = new 잃어버린강아지();
        int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(T.solution(arr1));
        int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
        System.out.println(T.solution(arr2));
    }
}
