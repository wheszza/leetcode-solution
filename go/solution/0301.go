/*
 * @Author: whe
 * @Date: 2022-02-28 22:10:31
 */
package solution

func removeInvalidParentheses(s string) []string {
	leftRemove, rightRemove := 0, 0
	for _, c := range s {
		if c == '(' {
			leftRemove++
		} else if c == ')' {
			if leftRemove == 0 {
				rightRemove++
			} else {
				leftRemove--
			}
		}
	}
	countLeft, countRight := 0, 0
	for _, c := range s {
		if c == '(' {
			countLeft++
		}
		if c == ')' {
			countRight++
		}
	}
	maxCount := minInt(countLeft, countRight)
	ansMap := make(map[string]int)
	var dfs func(id, score, leftCount, rightCount, leftRemove, rightRemove int, path string)
	dfs = func(id, score, leftCount, rightCount, leftRemove, rightRemove int, path string) {
		if score < 0 || score > maxCount {
			return
		}
		if id == len(s) {
			if leftRemove == 0 && rightRemove == 0 {
				if ansMap[path] == 0 {
					ansMap[path] = 1
				}
			}
			return
		}
		// 删除当前位置的字符
		c := s[id]
		if leftRemove > 0 && c == '(' {
			dfs(id+1, score, leftCount, rightCount, leftRemove-1, rightRemove, path)
		}
		if rightRemove > 0 && c == ')' {
			dfs(id+1, score, leftCount, rightCount, leftRemove, rightRemove-1, path)
		}
		// 保留当前位置字符
		if c != '(' && c != ')' {
			dfs(id+1, score, leftCount, rightCount, leftRemove, rightRemove, path+string(c))
		} else if c == '(' {
			dfs(id+1, score+1, leftCount+1, rightCount, leftRemove, rightRemove, path+string(c))
		} else if leftCount > rightCount {
			dfs(id+1, score-1, leftCount, rightCount+1, leftRemove, rightRemove, path+string(c))
		}
	}
	dfs(0, 0, 0, 0, leftRemove, rightRemove, "")
	ans := []string{}
	for k, v := range ansMap {
		if v == 1 {
			ans = append(ans, k)
		}
	}
	return ans
}
