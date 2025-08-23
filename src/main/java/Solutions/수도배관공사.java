package Solutions;

import java.util.Scanner;

public class 수도배관공사 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        int p = sc.nextInt();
        int[] dp = new int[d + 1];
        for(int i = 0 ; i < p ; i++){
            int l = sc.nextInt();
            int c = sc.nextInt();
            for(int j = d ; j > l ; j--){
                if(dp[j - l] == 0) continue;
                dp[j] = Math.max(dp[j], Math.min(dp[j-1], c));
            }
            dp[l] = Math.max(dp[l], c);
        }
        System.out.println(dp[d]);
    }
}
