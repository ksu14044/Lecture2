package Solutions;

import java.util.*;
class 최대길이연속수열 {
//    public int solution(int[] nums){
//        Arrays.sort(nums);
//        int max = Integer.MIN_VALUE;
//        for(int i = 0 ; i < nums.length ; i++){
//            int cnt = 1;
//            int cur = nums[i];
//            for(int j = i + 1 ; j < nums.length ; j++){
//                if(nums[j] == nums[j - 1]) continue;
//                if(nums[j] - cur == 1){
//                    cnt ++;
//                    cur ++;
//                } else {
//                    i = j;
//                    break;
//                }
//            }
//            max = Math.max(max, cnt);
//        }
//        return max;
//    }

    public int solution(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int max = 0;
        for(int x : set){
            if(set.contains(x - 1)) continue;
            int cnt = 1;
            while(set.contains(x + 1)){
                x++;
                cnt++;
            }
            max = Math.max(cnt, max);
        }
        return max;
    }

    public static void main(String[] args){
        최대길이연속수열 T = new 최대길이연속수열();
        System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
        System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
    }
}
