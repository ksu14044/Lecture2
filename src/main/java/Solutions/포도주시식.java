package Solutions;

import java.util.*;

public class 포도주시식 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] wines = new int[n + 1];
        for(int i = 1; i <= n ; i++){
            wines[i] = sc.nextInt();
        }
        int[] dp = new int[n + 1];
        if(n >= 1) dp[1] = wines[1];
        if(n >= 2) dp[2] = wines[1] + wines[2];
        for(int i = 3 ; i <= n ; i++){
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wines[i], dp[i - 3] + wines[i - 1] + wines[i]));
        }
        System.out.println(dp[n]);
    }
}