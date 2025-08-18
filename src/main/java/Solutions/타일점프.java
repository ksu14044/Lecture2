package Solutions;

import java.util.*;
class 타일점프 {
    public int solution(int[] nums){
        int n = nums.length;
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.offer(new int[]{0, 0});
        visited[0] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int pos = cur[0], cnt = cur[1];
            if(pos == n - 1) return cnt;
            int jump = nums[pos];
            for(int i = 1 ; i <= jump ; i++){
                int next = pos + i;
                if(next < n && !visited[next]){
                    visited[next] = true;
                    q.offer(new int[]{next, cnt + 1});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args){
        타일점프 T = new 타일점프();
        System.out.println(T.solution(new int[]{2, 2, 1, 2, 1, 1}));
        System.out.println(T.solution(new int[]{1, 0, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{2, 3, 1, 0, 1, 1, 2, 3, 1, 5, 1, 3, 1}));
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 1, 2, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{1, 3, 2, 1, 1, 2, 3, 1, 3, 1, 2, 3, 5, 1, 5, 1, 2, 1, 1}));
    }
}