/*
 * @Author: whe
 * @Date: 2022-03-01 11:23:22
 */
package solution

import "testing"

func Test0312(t *testing.T) {
	if maxCoins([]int{3, 1, 5, 8}) != 167 {
		t.Log("the ans should be 167!")
		t.Fail()
	}
	if maxCoins([]int{1, 5}) != 10 {
		t.Log("the ans should be 10!")
		t.Fail()
	}
}
