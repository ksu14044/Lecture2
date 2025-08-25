package Solutions;

import java.util.*;

public class 수확 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0 ; i < n ; i++){
            nums[i] = sc.nextInt();
        }
        sc.close();
        int[][] dp = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            dp[i][i] = nums[i] * n;
        }
        for(int len = 2 ; len <= n ; len++){
            for(int l = 0 ; l + len - 1 < n ; l++){
                int r = l + len - 1;
                int k = n - (r - l);
                dp[l][r] = Math.max(nums[l] * k + dp[l + 1][r], nums[r] * k + dp[l][r - 1]);
            }
        }

        System.out.println(dp[0][n-1]);
    }
}
