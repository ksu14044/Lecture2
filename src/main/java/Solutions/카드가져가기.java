package Solutions;

import java.util.*;

class 카드가져가기 {
    public int solution(int[] nums, int k){
        int answer = 0;
        Arrays.sort(nums);
        int n = nums.length;
        int[] gap = new int[n / 2];
        int idx = 0;
        for(int i = 0 ; i < n - 1 ; i += 2){
            gap[idx++] = nums[i + 1] - nums[i];
            answer += nums[i];
        }
        Arrays.sort(gap);
        for(int i = 0 ; i < k ; i++){
            answer += gap[n / 2 - i - 1];
        }
        return answer;
    }

    public static void main(String[] args){
        카드가져가기 T = new 카드가져가기();
        System.out.println(T.solution(new int[]{7, 8, 5, 12, 3, 1, 3, 1, 1, 12}, 2));
        System.out.println(T.solution(new int[]{8, 2, 12, 12, 12, 12, 2, 2}, 2));
        System.out.println(T.solution(new int[]{3, 7, 12, 3, 3, 5, 7, 8, 9, 11, 23, 4, 6, 7}, 3));
        System.out.println(T.solution(new int[]{12, 34, 56, 23, 22, 34, 55, 45, 24, 23, 45, 55, 55, 23, 11, 12, 23, 12}, 3));
        System.out.println(T.solution(new int[]{14, 15, 20, 11, 10, 20, 20, 12, 9, 22, 27, 25, 30, 19}, 3));
    }
}