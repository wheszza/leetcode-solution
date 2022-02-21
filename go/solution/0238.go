/*
 * @Author: whe
 * @Date: 2022-02-21 16:47:12
 */

package solution

func productExceptSelf(nums []int) []int {
	ans := make([]int, len(nums))
	ans[0] = 1
	//ans[i]存对角线左边的乘积
	for i := 1; i < len(nums); i++ {
		ans[i] = ans[i-1] * nums[i-1]
	}
	//t存对角线右边乘积
	t := 1
	for i := len(nums) - 2; i >= 0; i-- {
		t = t * nums[i+1]
		ans[i] = ans[i] * t
	}
	return ans
}
