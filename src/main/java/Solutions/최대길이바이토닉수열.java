package Solutions;

class 최대길이바이토닉수열 {
    public int solution(int[] nums){
        int answer = 0;
        for(int i = 1 ; i < nums.length - 1 ; i++){
            int cur = nums[i];
            int left = -1;
            int right = -1;
            for(int j = i - 1 ; j > 0 ; j--){
                if(nums[j] < cur){
                    cur = nums[j];
                    left = j;
                } else break;
            }
            cur = nums[i];
            for(int j = i + 1 ; j < nums.length ; j++){
                if(nums[j] < cur){
                    cur = nums[j];
                    right = j;
                } else break;
            }
            if(left != -1 && right != -1){
                int len = right - left + 1;
                answer = Math.max(answer, len);
            }
        }
        return answer;
    }

//    public int solution(int[] nums){
//        int answer = 0;
    // peaks => 봉우리로 가능한 지점 인덱스 번호 모음
//        List<Integer> peaks = new ArrayList<>();
//        for(int i = 1 ; i < nums.length - 1 ; i++){
//            if(nums[i - 1] < nums[i] && nums[i] > nums[i + 1]){
//                peaks.add(i);
//            }
//        }
//        for(int x : peaks){
//            int left = x;
//            int right = x;
//            int cnt = 1;
//            while(left - 1 >= 0 && nums[left - 1] < nums[left]){
//                left--;
//                cnt++;
//            }
//            while(right + 1 < nums.length && nums[right] > nums[right + 1]){
//                right++;
//                cnt++;
//            }
//            answer = Math.max(answer, cnt);
//        }
//        return answer;
//    }

    public static void main(String[] args){
        최대길이바이토닉수열 T = new 최대길이바이토닉수열();
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 3, 2, 1}));
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }
}