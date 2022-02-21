/*
 * @Author: whe
 * @Date: 2022-02-21 16:59:57
 */

public class _0238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        int t = 1;
        for (int i = n - 2; i >= 0; i--) {
            ans[i] = nums[i + 1] * t  * ans[i];
            t = t * nums[i + 1];
        }
        return ans;
    }
}