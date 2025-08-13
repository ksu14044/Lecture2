package Solutions;

import java.util.*;
class 이진수정렬 {
    public int[] solution(int[] nums){
        int[] answer = new int[nums.length];
//        List<Integer> l = new ArrayList<>();
//        for(int n : nums) l.add(n);
//        l.sort((a, b) -> findOne(a) == findOne(b) ? a - b : findOne(a) - findOne(b));
//        for(int i = 0 ; i < nums.length ; i++){
//            answer[i] = l.get(i);
//        }
        int[][] n = new int[nums.length][2];
        for(int i = 0 ; i < n.length ; i++){
            n[i][0] = nums[i];
            n[i][1] = findOne(nums[i]);
        }
        Arrays.sort(n, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        for(int i = 0 ; i < answer.length ; i++){
            answer[i] = n[i][0];
        }
        return answer;
    }

    public static void main(String[] args){
        이진수정렬 T = new 이진수정렬();
        System.out.println(Arrays.toString(T.solution(new int[]{5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(T.solution(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(T.solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
    }

    public int findOne(int x){
        int cnt = 0;
        while(x > 0){
            if(x % 2 == 1) cnt++;
            x /= 2;
        }
        return cnt;
    }
}
