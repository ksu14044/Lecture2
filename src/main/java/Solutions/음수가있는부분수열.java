package Solutions;

import java.util.*;
class 음수가있는부분수열 {
//    public int solution(int[] nums, int m){
//        int answer = 0;
//        int n = nums.length;
//        for(int i = 0 ; i < n ; i++){
//            int sum = 0;
//            for(int j = i ; j < n ; j++){
//                sum += nums[j];
//                if(sum == m) answer++;
//            }
//        }
//        return answer;
//    }

    public int solution(int[] nums, int m){
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, 1);
        for(int i = 0 ; i < nums.length ; i++){
            // 앞에서부터 합 저장
            sum += nums[i];
            // 여기까지의 합 - m 이 map 에 존재한다면
            if(map.containsKey(sum - m)){
                // 그 빈도수만큼 m이 가능
                // ex) 0 ~ 3 까지가 2 / m == 5일때 0 ~ 5까지 합이 7 이라면
                // 4 ~ 5까지가 5라는 뜻
                // 0 ~ 1 까지도 2라면 map 에 (key) 2 : (value) 2로 저장
                // 그럼 2 ~ 5 / 4 ~ 5까지가 5가 되므로 빈도수(value)만큼 answer에 추가
                answer += map.get(sum - m);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return answer;
    }

    public static void main(String[] args){
        음수가있는부분수열 T = new 음수가있는부분수열();
        System.out.println(T.solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2}, 3));
        System.out.println(T.solution(new int[]{-1, 0, 1}, 0));
        System.out.println(T.solution(new int[]{-1, -1, -1, 1}, 0));
    }
}
