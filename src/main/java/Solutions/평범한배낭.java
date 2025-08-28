package Solutions;
import java.util.*;

public class 평범한배낭 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] weights = new int[n + 1];
        int[] values = new int[n + 1];
        for(int i = 1 ; i <= n ; i++){
            int w = sc.nextInt();
            int v = sc.nextInt();
            weights[i] = w;
            values[i] = v;
        }
        // dp[j] = 무게 j까지 담을 수 있을 떄의 최대 가치
        int[] dp = new int[k + 1];
        // i = 현재 물건
        for(int i = 1 ; i <= n ; i++){
            for(int j = k ; j >= weights[i] ; j--){
                // dp[j] = 현재 물건을 담지 않았을 때 vs dp[j - weights[i]] + values[i] = 현재 물건을 담았을 때
                dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
            }
        }
        System.out.println(dp[k]);

    }
}
