package Solutions;

import java.util.*;
class 모임장소 {
    public int solution(int[][] board){
        List<Integer> xl = new ArrayList<>();
        List<Integer> yl = new ArrayList<>();
        int n = board.length;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ;j++){
                if(board[i][j] == 1){
                    xl.add(i);
                    yl.add(j);
                }
            }
        }
        Collections.sort(xl);
        Collections.sort(yl);
        int cx = xl.get(xl.size() / 2);
        int cy = yl.get(yl.size() / 2);
        int sum = 0;
        for(int i = 0 ; i < xl.size() ; i++){
            sum += Math.abs(cx - xl.get(i));
            sum += Math.abs(cy - yl.get(i));
        }
        return sum;

    }

    public static void main(String[] args){
        모임장소 T = new 모임장소();
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1, 1}, {0, 1, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 1, 1}}));
    }
}