package Solutions;

import java.util.*;

public class 등차수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] an = new int[n + 1];
        for(int i = 1 ; i <= n ; i++){
            an[i] = sc.nextInt();
        }
        if(n == 1) {
            System.out.println(1);
            return;
        };
        if(n == 2) {
            System.out.println(2);
            return;
        }
        Arrays.sort(an);
        int max = 2;
        int[][] dp = new int[n + 1][n + 1];
        for(int i = 1 ; i < n ; i++){
            for(int j = i + 1 ; j < n + 1 ; j++){
                dp[i][j] = 2;
                int pre = 2*an[i] - an[j];
//                int k = 0;
//                for(k = i - 1 ; k >= 1 ; k--){
//                    if(an[k] == pre) break;
//                }
//                dp[i][j] = Math.max(dp[i][j], dp[k][i] + 1);
                int left = 1;
                int right = i - 1;
                int mid = 0;
                while(left < right){
                    mid = (left + right) / 2;
                    if(an[mid] < pre) left = mid + 1;
                    else if(an[mid] == pre && an[right] == pre) left = mid + 1;
                    else right = mid;
                }
                if(an[right] == pre){
                    dp[i][j] = Math.max(dp[i][j], dp[right][i] + 1);
                }
                max = Math.max(dp[i][j], max);
            }
        }
        System.out.println(max);
    }
}
