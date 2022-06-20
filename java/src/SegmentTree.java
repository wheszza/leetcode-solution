/*
 * @Author: whe
 * @Date: 2022-06-20 15:17:39
 */
public class SegmentTree {
    class Node {
        Node left, right;
        int val;
        int add; //懒标记
    }
    /*
     * n 当前节点
     * l 查询左边界
     * r 查询右边界
     * s n节点左边界
     * e n节点右边界
     */
    int query(Node n, int l, int r, int s, int e) {
        if (l <= s && e <= r) {
            return n.val;
        }
        int mid = (s + e) >> 1;
        int ans = 0;
        pushDown(n, mid - s + 1, e - mid);
        if (l <= mid) ans += query(n.left, l, r, s, mid);
        if (r > mid) ans += query(n.right, l, r, mid + 1, e);
        return ans;
    }
    /*
     * n 当前节点
     * l 更新左边界
     * r 更新右边界
     * s n节点左边界
     * e n节点右边界
     */
    void update(Node n, int l, int r, int s, int e, int val) {
        if (l <= s && e <= r) {
            n.val += (e - s + 1) * val;
            n.add += val;
            return;
        }
        int mid = (s + e) >> 1;
        pushDown(n, mid - s + 1, e - mid);
        if (l <= mid) update(n.left, l, r, s, mid, val);
        if (r > mid) update(n.right, l, r, mid + 1, e, val);
        pushUp(n);
    }
    //利用子区间更新该区间
    void pushUp(Node n) {
        n.val = n.left.val + n.right.val;
    }
    //利用该区间更新子区间，并传递懒标记
    void pushDown(Node n, int leftNum, int rightNum) {
        if (n.left == null) n.left = new Node();
        if (n.right == null) n.right = new Node();
        if (n.add == 0) return;
        n.left.val += leftNum * n.add;
        n.right.val += rightNum * n.add;
        n.left.add += n.add;
        n.right.add += n.add;
        n.add = 0;
    }
}
