/*
 * @Author: whe
 * @Date: 2022-02-20 17:25:16
 */
package solution

import "testing"

func Test0200(t *testing.T) {
	if numIslands([][]byte{
		{49, 49, 48, 48, 48},
		{49, 49, 48, 48, 48},
		{48, 48, 49, 48, 48},
		{48, 48, 48, 49, 49}}) != 3 {
		t.Log("the ans should be 6!")
		t.Fail()
	}
	if numIslands([][]byte{
		{49, 49, 49, 49, 48},
		{49, 49, 48, 49, 48},
		{49, 49, 48, 48, 48},
		{48, 48, 48, 48, 48}}) != 1 {
		t.Log("the ans should be 1!")
		t.Fail()
	}
}
