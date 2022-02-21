/*
 * @Author: whe
 * @Date: 2022-02-21 16:47:21
 */
package solution

import "testing"

func Test0238(t *testing.T) {
	t1 := productExceptSelf([]int{1, 2, 3, 4})
	a1 := []int{24, 12, 8, 6}
	for i := range t1 {
		if t1[i] != a1[i] {
			t.Log("the ans should be 6!")
			t.Fail()
		}
	}
	t2 := productExceptSelf([]int{-1, 1, 0, -3, 3})
	a2 := []int{0, 0, 9, 0, 0}
	for i := range t1 {
		if t2[i] != a2[i] {
			t.Log("the ans should be 6!")
			t.Fail()
		}
	}
}
