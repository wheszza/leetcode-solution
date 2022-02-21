/*
 * @Author: whe
 * @Date: 2022-02-21 17:23:30
 */
package solution

//动态规划
func maximalSquare(matrix [][]byte) int {
	m, n := len(matrix), len(matrix[0])
	dp, side := make([][]int, m), 0
	for i := range dp {
		dp[i] = make([]int, n)
	}
	for i := range matrix {
		for j := range matrix[0] {
			if i == 0 || j == 0 {
				dp[i][j] = int(matrix[i][j] - '0')
			} else {
				if matrix[i][j] == '1' {
					dp[i][j] = minInt(dp[i-1][j], minInt(dp[i][j-1], dp[i-1][j-1])) + 1
				}
			}
			side = maxInt(side, dp[i][j])
		}
	}
	return side * side
}

/*前缀和
func maximalSquare(matrix [][]byte) int {
	m, n := len(matrix), len(matrix[0])
	preSum, ans := make([][]int, m+1), 0
	for i := range preSum {
		preSum[i] = make([]int, n+1)
	}
	for i := 1; i <= m; i++ {
            for j := 1; j <= n; j++ {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] + int(matrix[i - 1][j - 1] - '0')- preSum[i - 1][j - 1];
            }
        }
	for i := range matrix {
		for j := range matrix[0] {
			l, sum := 0, 0
        	for sum == l * l {
                    ans = maxInt(ans, sum)
                    l++
                    if (i + l > m || j + l > n) {
						break
					}
                    sum = preSum[i + l][j + l] + preSum[i][j] - preSum[i + l][j] - preSum[i][j + l]
                }
		}
	}
	return ans
}
*/
