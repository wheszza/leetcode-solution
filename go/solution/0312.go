/*
 * @Author: whe
 * @Date: 2022-03-01 11:21:53
 */
package solution

func maxCoins(nums []int) int {
	n := len(nums)
	temp := make([]int, n+2)
	temp[0], temp[n+1] = 1, 1
	for i := range nums {
		temp[i+1] = nums[i]
	}
	dp := make([][]int, n+2)
	for i := range dp {
		dp[i] = make([]int, n+2)
	}
	//开区间长度
	for len := 3; len <= n+2; len++ {
		//开区间左端点
		for i := 0; i+len <= n+2; i++ {
			res := 0
			// k为开区间内的索引
			// k为区间内最后一个戳破的气球
			for k := i + 1; k < i+len-1; k++ {
				left := dp[i][k]
				right := dp[k][i+len-1]
				res = maxInt(res, left+temp[i]*temp[k]*temp[i+len-1]+right)
			}
			dp[i][i+len-1] = res
		}
	}
	return dp[0][n+1]
}
