package Solutions;


import java.util.*;

public class 팰린드롬만들기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n + 1];

        for(int i = 1 ; i <= n ; i++){
            nums[i] = sc.nextInt();
        }

        int[][] dp = new int[n + 1][n + 1];
        // i = 수열의 길이
        for(int i = 1; i < n; i++){
            // j = 시작 번호
            for(int j = 1; j <= n - i ; j++){
                // 시작 번호랑 끝 번호가 같다면
                if(nums[j] == nums[j + i]){
                    // 중간에 있는 거 만큼만
                    dp[j][j + i] = dp[j + 1][j + i - 1];
                    // 다르다면
                } else {
                    // 왼쪽부터 끝 전까지랑 시작 바로 오른쪽부터 끝까지랑 비교해서 작은거 + 1
                    dp[j][j + i] = Math.min(dp[j][j + i - 1], dp[j + 1][j + i]) + 1;
                }
            }
        }

        System.out.println(dp[1][n]);
        sc.close();
    }
}
