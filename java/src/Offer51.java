public class Offer51 {

    public static void main(String[] args) {
        Offer51 test = new Offer51();
        test.reversePairs(new int[]{1,3,2,3,1});
    }

    int ans = 0;
    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return ans;
    }
    private void mergeSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int m = (l + r) / 2;
        mergeSort(nums, l, m);
        mergeSort(nums, m + 1, r);
        int[] t = new int[r - l + 1];
        for (int x = l; x <= r; x++) {
            t[x - l] = nums[x];
        }
        int i = l, j = m + 1;
        for (int k = l; k <= r; k++) {
            if (i == m + 1) {
                nums[k] = t[j++ - l];
            } else if (j == r + 1 || t[i - l] < t[j - l]) {
                nums[k] = t[i++ - l];
            } else {
                nums[k] = t[j++ - l];
                ans += m - i + 1; // 统计逆序对
            }
        }
    }
}
