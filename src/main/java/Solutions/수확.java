package Solutions;

import java.util.*;

public class 수확 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n + 1];
        for(int i = 1 ; i <= n ; i++){
            nums[i] = sc.nextInt();
        }
        sc.close();
        int[][] dp = new int[n  + 1][n + 1];
        for(int i = 0 ; i < n ; i++){
            dp[i][i] = nums[i];
        }
        int[] sum = new int[n + 1];
        sum[1] = nums[1];
        for(int i = 2 ; i <= n ; i++){
            sum[i] = sum[i - 1] + nums[i];
        }
        for(int i = 1; i <= n ; i++){
            for(int j = 1; j + i <= n ; j++){
                dp[j][j + i] = Math.max(dp[j + 1][j + i], dp[j][j + i - 1]) + sum[j + i] - sum[j - 1];
            }
        }
        System.out.println(dp[1][n]);
    }
}
