package Solutions;

import java.util.*;
class 꽃이피는최단시간 {
    public int solution(int[] plantTime, int[] growTime){
        int answer = 0;
        int n = plantTime.length;
        int[][] list = new int[n][2];
        for(int i = 0 ; i < n ; i++){
            list[i][0] = plantTime[i];
            list[i][1] = growTime[i];
        }
        Arrays.sort(list, (a, b) -> b[1] - a[1]);
        int time = 0;
        for(int[] x : list){
            time += x[0];
            answer = Math.max(time + x[1], answer);
        }
        return answer;
    }

    public static void main(String[] args){
        꽃이피는최단시간 T = new 꽃이피는최단시간();
        System.out.println(T.solution(new int[]{1, 3, 2}, new int[]{2, 3, 2}));
        System.out.println(T.solution(new int[]{2, 1, 4, 3}, new int[]{2, 5, 3, 1}));
        System.out.println(T.solution(new int[]{1, 1, 1}, new int[]{7, 3, 2}));
        System.out.println(T.solution(new int[]{5, 7, 10, 15, 7, 3, 5}, new int[]{6, 7, 2, 10, 15, 6, 7}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{7, 5, 4, 3, 2, 1, 6}));
    }
}
