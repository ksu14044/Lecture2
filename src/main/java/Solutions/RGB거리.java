package Solutions;
import java.util.*;

public class RGB거리 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] costs = new int[n + 1][3];
        for(int i = 1 ; i <= n ; i++){
            for(int j = 0 ; j < 3; j++){
                costs[i][j] = sc.nextInt();
            }
        }
        int[][] dp = new int[n + 1][3];
        dp[1][0] = costs[1][0];
        dp[1][1] = costs[1][1];
        dp[1][2] = costs[1][2];
        
        for(int i = 2 ; i < n + 1 ; i++){
            dp[i][0] = costs[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }
        int answer = Integer.MAX_VALUE;
        for(int i = 0 ; i < 3; i++){
            answer = Math.min(dp[n][i], answer);
        }
        System.out.println(answer);
    }
}
