package Solutions;

import java.util.*;

public class 퇴사 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] t = new int[n + 2];
        int[] p = new int[n + 2];
        for(int i = 1 ; i <= n ; i++){
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        int[] dp = new int[n + 2];
        for(int i = n ; i >= 1 ; i--){
            dp[i] = dp[i + 1];
            if(i + t[i] <= n + 1){
                dp[i] = Math.max(dp[i], p[i] + dp[i + t[i]]);
            }
        }
        System.out.println(dp[1]);

    }
}
