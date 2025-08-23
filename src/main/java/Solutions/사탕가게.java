package Solutions;

import java.util.*;

public class 사탕가게 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            int n = sc.nextInt();
            int m = (int)(Math.round(sc.nextDouble() * 100));
            if(n == 0 && m == 0) {
                sc.close();
                break;
            }
            int[] dp = new int[m + 1];
            for(int i = 0 ; i < n ; i++){
                int c = sc.nextInt();
                int p = (int)(Math.round(sc.nextDouble() * 100));
                for(int j = p ; j <= m ; j++){
                    int totalC = dp[j - p] + c;
                    dp[j] = Math.max(dp[j], totalC);
                }
            }
            System.out.println(dp[m]);
        }
        sc.close();
    }
}
