/*
 * @Author: whe
 * @Date: 2022-02-15 14:52:31
 */
package solution

import (
	"math"
)

//maxInt is defined in tools.go

func maxPathSum(root *TreeNode) int {
	ans := math.MinInt
	var dfs func(r *TreeNode) int
	dfs = func(r *TreeNode) int {
		if r == nil {
			return 0
		}
		left, right := dfs(r.Left), dfs(r.Right)
		ans = maxInt(ans, left+r.Val+right)
		max := maxInt(r.Val+left, r.Val+right)
		if max < 0 {
			return 0
		}
		return max
	}
	dfs(root)
	return ans
}
