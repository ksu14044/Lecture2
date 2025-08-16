package Solutions;

import java.util.*;
class 가장가까운큰수 {
    // (전역) 변수 사용 시 주의점
    // 반드시 solution 안에서 초기화
    int answer, target, m;
    boolean[] visited;
    boolean flag;
    List<Integer> nums;
    public int solution(int n){
        answer = 0;
        nums = new ArrayList<>();
        target = n;
        flag = false;
        int tmp = n;
        while(tmp > 0){
            int x = tmp % 10;
            nums.add(x);
            tmp /= 10;
        }
        nums.sort((a, b) -> a - b);
        m = nums.size();
        visited = new boolean[m];
        dfs(0, 0);
        return flag ? answer : -1;
    }

    public void dfs(int l, int num){
        if(flag) return;
        if(l == m){
            if(num > target){
                answer = num;
                flag = true;
            }
        }
        for(int i = 0 ; i < nums.size() ; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(l + 1, num * 10 + nums.get(i));
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args){
        가장가까운큰수 T = new 가장가까운큰수();
        System.out.println(T.solution(123));
        System.out.println(T.solution(321));
        System.out.println(T.solution(20573));
        System.out.println(T.solution(27711));
        System.out.println(T.solution(54312));
    }
}
