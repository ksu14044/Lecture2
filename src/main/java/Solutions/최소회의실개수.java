package Solutions;

import java.util.*;
class 최소회의실개수 {
//    public int solution(int[][] meetings){
//        int answer = 0;
//        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        int n = meetings.length;
//        for(int i = 0; i < n ; i++){
//            int start = meetings[i][0], end = meetings[i][1];
//            while(!pq.isEmpty() && pq.peek() <= start){
//                pq.poll();
//            }
//            pq.offer(end);
//            answer = Math.max(pq.size(), answer);
//        }
//        return answer;
//    }
    public int solution(int[][] meetings){
        int answer = 0;
        int n = meetings.length;
        List<int[]> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            int start = meetings[i][0], end = meetings[i][1];
            list.add(new int[]{start, 1});
            list.add(new int[]{end, 2});
        }
        int max = Integer.MIN_VALUE;
        list.sort((a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        for(int[] l : list){
            if(l[1] == 1) answer ++;
            else answer --;
            max = Math.max(max, answer);
        }
        return max;
    }

    public static void main(String[] args){
        최소회의실개수 T = new 최소회의실개수();
        System.out.println(T.solution(new int[][]{{0, 10}, {20, 25}, {5, 15}, {2, 5}}));
        System.out.println(T.solution(new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
    }
}
