/*
 * @Author: whe
 * @Date: 2022-02-09 21:43:55
 */
package solution

import (
	"strconv"
	"strings"
)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func StrToTree(s string) *TreeNode {
	st := strings.Split(s, ",")
	treeVec := make([]*TreeNode, len(st))
	for i, t := range st {
		val, ok := strconv.Atoi(t)
		if ok == nil {
			treeVec[i] = &TreeNode{val, nil, nil}
		}
	}
	for i := 0; 2*i+2 < len(st); i++ {
		if treeVec[i] != nil {
			treeVec[i].Left = treeVec[2*i+1]
			treeVec[i].Right = treeVec[2*i+2]
		}

	}
	return treeVec[0]
}

func TreeToStr(root *TreeNode) string {
	ans := ""
	q := []*TreeNode{root}
	for len(q) > 0 {
		size := len(q)
		for i := 0; i < size; i++ {
			if q[0] != nil {
				ans += strconv.Itoa(q[0].Val)
				q = append(q, q[0].Left, q[0].Right)
				q = q[1:]
			} else {
				q = q[1:]
				ans += "nil"
			}
			ans += " "
		}
	}
	return ans
}
