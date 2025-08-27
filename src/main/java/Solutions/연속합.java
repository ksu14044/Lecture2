package Solutions;
import java.util.*;

public class 연속합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0 ; i < n ; i++){
            nums[i] = sc.nextInt();
        }
        int[] sums = new int[n];
        sums[0] = nums[0];
        int answer = Integer.MIN_VALUE;
        for(int i = 1 ; i < n ; i++){
            sums[i] = Math.max(nums[i], sums[i - 1] + nums[i]);
            answer = Math.max(sums[i], answer);
        }
        answer = Math.max(sums[0], answer);
        System.out.println(answer);

    }
}
