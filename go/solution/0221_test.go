/*
 * @Author: whe
 * @Date: 2022-02-21 17:25:08
 */
package solution

import "testing"

func Test0221(t *testing.T) {
	if maximalSquare([][]byte{
		{'1', '0', '1', '0', '0'},
		{'1', '0', '1', '1', '1'},
		{'1', '1', '1', '1', '1'},
		{'1', '0', '0', '1', '0'}}) != 4 {
		t.Log("the ans should be 4!")
		t.Fail()
	}
	if maximalSquare([][]byte{
		{'0', '1'},
		{'1', '0'}}) != 1 {
		t.Log("the ans should be 1!")
		t.Fail()
	}
}
