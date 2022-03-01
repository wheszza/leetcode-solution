/*
 * @Author: whe
 * @Date: 2022-03-01 10:46:01
 */
package solution

import "testing"

func Test0006(t *testing.T) {
	if convert("PAYPALISHIRING", 3) != "PAHNAPLSIIGYIR" {
		t.Log("the ans should be PAHNAPLSIIGYIR!")
		t.Fail()
	}
	if convert("PAYPALISHIRING", 4) != "PINALSIGYAHRPI" {
		t.Log("the ans should be PINALSIGYAHRPI!")
		t.Fail()
	}
}
