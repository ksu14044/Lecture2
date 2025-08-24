package Solutions;

import java.util.Scanner;

public class 계단오르기 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] stairs = new int[n + 1];
//        for(int i = 1 ; i <= n ; i++){
//            stairs[i] = sc.nextInt();
//        }
//        if(n <= 1){
//            System.out.println(stairs[1]);
//            return;
//        }
//        int[][] dp = new int[n + 1][2];
//        dp[1][0] = stairs[1];
//        dp[2][0] = stairs[1] + stairs[2];
//        dp[2][1] = stairs[2];
//        for(int i = 3 ; i <= n ; i++){
//            dp[i][0] = dp[i - 1][1] + stairs[i];
//            dp[i][1] = Math.max(dp[i - 2][0], dp[i - 2][1]) + stairs[i];
//        }
//        System.out.println(Math.max(dp[n][0], dp[n][1]));
//        sc.close();
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n + 1];
        for(int i = 1 ; i < n + 1 ; i++){
            scores[i] = sc.nextInt();
        }
        int[] dp = new int[n + 1];
        dp[1] = scores[1];
        dp[2] = scores[1] + scores[2];
        for(int i = 3 ; i < n + 1 ; i++){
            dp[i] = Math.max(dp[i - 2] + scores[i], dp[i - 3] + scores[i - 1] + scores[i]);
        }
        System.out.println(dp[n]);
    }
}
