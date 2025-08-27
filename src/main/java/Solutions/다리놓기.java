package Solutions;
import java.util.*;

public class 다리놓기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0 ; i < t ; i++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] dp = new int[n + 1][m + 1];
            for(int j = 1 ; j < n + 1 ; j++){
                dp[j][j] = 1;
            }
            for(int j = 1 ; j < m + 1; j++){
                dp[1][j] = j;
            }
            for(int r = 2 ; r < n + 1 ; r++){
                for(int c = r ; c < m + 1; c++){
                    dp[r][c] = dp[r - 1][c - 1] + dp[r][c - 1];
                }
            }
            System.out.println(dp[n][m]);
        }
    }


}
