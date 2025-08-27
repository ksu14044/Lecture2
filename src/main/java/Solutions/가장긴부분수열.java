package Solutions;

import java.util.*;

public class 가장긴부분수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int[] dp = new int[n];
        for(int i = 0 ; i < n ; i++){
            nums[i] = sc.nextInt();
            dp[i] = 1;
        }
        int maxLen = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < i ; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(dp[i], maxLen);
        }
        System.out.println(maxLen);
    }
}
