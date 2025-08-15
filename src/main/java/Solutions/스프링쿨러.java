package Solutions;

import java.util.*;
class 스프링쿨러 {
    public int solution(int n, int[] nums){
        int answer = 0;
        int[][] list = new int[n][2];
        for(int i = 0 ; i < n ; i++){
            int start = Math.max(0, i - nums[i]);
            int end = Math.min(n, i + nums[i]);
            list[i][0] = start;
            list[i][1] = end;
        }
        Arrays.sort(list, (a, b) -> a[0] - b[0]);
        System.out.println(Arrays.deepToString(list));
        int s = 0, e = 0, i = 0;
        while(i < list.length){
            // s는 시작지점이라는 뜻이지만 사실상 현재까지 커버한 영역을 의미
            while(i < list.length && list[i][0] <= s){
                // 현재까지 커버한 영역이후로 얼마나 더 많이 커버할 수 있는가
                e = Math.max(e, list[i][1]);
                i++;
            }
            // 제일 많이 나아갈 수 있는 지점에서 스프링쿨러 추가
            answer++;
            // 제일 많이 나아간 지점이 n 이라면 커버완료 끝
            if(e == n) return answer;
            // 더 이상 나아갈 수 있는 영역이 없다면 커버 불가능
            if(s == e) return -1;
            // 나아갔으니 커버한 영역으로 바꿈
            s = e;
        }
        return answer;
    }

    public static void main(String[] args){
        스프링쿨러 T = new 스프링쿨러();
        System.out.println(T.solution(8, new int[]{1, 1, 1, 2, 1, 1, 2, 1, 1}));
        System.out.println(T.solution(4, new int[]{1, 2, 2, 0, 0}));
        System.out.println(T.solution(5, new int[]{2, 0, 0, 0, 0, 2}));
        System.out.println(T.solution(11, new int[]{1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1}));
    }
}
