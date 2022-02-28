/*
 * @Author: whe
 * @Date: 2022-02-28 22:16:36
 */

package solution

import "testing"

func Test0301(t *testing.T) {
	t1 := removeInvalidParentheses("()())()")
	t2 := removeInvalidParentheses("(a)())()")
	a1 := []string{"(())()", "()()()"}
	a2 := []string{"(a())()", "(a)()()"}
	for i := range t1 {
		if t1[i] != a1[i] {
			t.Log("the ans should be" + a1[i])
			t.Fail()
		}
	}
	for i := range t2 {
		if t2[i] != a2[i] {
			t.Log("the ans should be" + a2[i])
			t.Fail()
		}
	}
}
