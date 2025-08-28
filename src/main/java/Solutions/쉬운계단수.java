package Solutions;

import java.util.Scanner;

public class 쉬운계단수 {
    public static void main(String[] args) {
        int mod = 1_000_000_000;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[n + 1][10];
        for(int i = 1 ; i <= 9 ; i++){
            dp[1][i] = 1;
        }
        for(int i = 2 ; i <= n ; i++){
            for(int j = 0 ; j <= 9 ; j++){
                if(j > 0) dp[i][j] += dp[i - 1][j - 1];
                if(j < 9) dp[i][j] += dp[i - 1][j + 1];
                dp[i][j] %= mod;
            }
        }
        int result = 0;
        for(int i = 0 ; i <= 9 ; i++){
            result = (result + dp[n][i]) % mod;
        }
        System.out.println(result);
    }
}


