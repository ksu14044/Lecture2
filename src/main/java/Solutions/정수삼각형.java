package Solutions;

import java.util.*;

public class 정수삼각형 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int idx = 1;
        int[][] nums = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < idx ; j++){
                nums[i][j] = sc.nextInt();
            }
            idx++;
        }
        int[][] dp = new int[n][n];
        dp[0][0] = nums[0][0];
        int len = 1;
        for(int i = 1 ; i < n ; i++){
            dp[i][0] = dp[i - 1][0] + nums[i][0];
            for(int j = 1; j < len ; j++){
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + nums[i][j];
            }
            dp[i][len] = dp[i-1][len - 1] + nums[i][len];
            len++;
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            max = Math.max(dp[n-1][i], max);
        }
        System.out.println(max);
    }
}
