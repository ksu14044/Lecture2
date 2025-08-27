package Solutions;
import java.util.*;

public class 부녀회장이될테야 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0 ; i < t ; i++){
            int k = sc.nextInt();
            int n = sc.nextInt();
            int[][] dp = new int[k + 1][n + 1];
            for(int j = 1 ; j < n + 1 ; j++){
                dp[0][j] = j;
            }
            for(int j = 1; j < k + 1 ; j++){
                for(int p = 1 ; p < n + 1 ; p++){
                    dp[j][p] = dp[j][p - 1] + dp[j - 1][p];
                }
            }
            System.out.println(dp[k][n]);
        }
    }
}
