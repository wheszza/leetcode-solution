/*
 * @Author: whe
 * @Date: 2022-02-15 15:04:56
 */
package solution

import "testing"

func Test0124(t *testing.T) {
	if maxPathSum(StrToTree("1,2,3")) != 6 {
		t.Log("the ans should be 6!")
		t.Fail()
	}
	if maxPathSum(StrToTree("-10,9,20,null,null,15,7")) != 42 {
		t.Log("the ans should be 42!")
		t.Fail()
	}
}
