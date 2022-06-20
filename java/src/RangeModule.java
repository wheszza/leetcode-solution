/*
 * @Author: whe
 * @Date: 2022-06-20 16:07:31
 */
class RangeModule {

    class Node {
        Node left, right;
        boolean cover;
        int add; // 懒标记
    }

    /*
     * n 当前节点
     * l 查询左边界
     * r 查询右边界
     * s n节点左边界
     * e n节点右边界
     */
    boolean query(Node n, int l, int r, int s, int e) {
        if (l <= s && e <= r) {
            return n.cover;
        }
        int mid = (s + e) >> 1;
        boolean ans = true;
        pushDown(n, mid - s + 1, e - mid);
        if (l <= mid)
            ans = ans && query(n.left, l, r, s, mid);
        if (r > mid)
            ans = ans && query(n.right, l, r, mid + 1, e);
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
            n.cover = val == 1;
            n.add = val;
            return;
        }
        int mid = (s + e) >> 1;
        pushDown(n, mid - s + 1, e - mid);
        if (l <= mid)
            update(n.left, l, r, s, mid, val);
        if (r > mid)
            update(n.right, l, r, mid + 1, e, val);
        pushUp(n);
    }

    // 利用子区间更新该区间
    void pushUp(Node n) {
        n.cover = n.left.cover && n.right.cover;
    }

    // 利用该区间更新子区间，并传递懒标记
    void pushDown(Node n, int leftNum, int rightNum) {
        if (n.left == null)
            n.left = new Node();
        if (n.right == null)
            n.right = new Node();
        if (n.add == 0)
            return;
        n.left.cover = n.add == 1;
        n.right.cover = n.add == 1;
        n.left.add = n.add;
        n.right.add = n.add;
        n.add = 0;
    }

    private Node root = new Node();
    private int N = (int) 21;

    public RangeModule() {

    }

    public void addRange(int left, int right) {
        update(root, left, right - 1, 1, N, 1);
    }

    public boolean queryRange(int left, int right) {
        return query(root, left, right - 1, 1, N);
    }

    public void removeRange(int left, int right) {
        update(root, left, right - 1, 1, N, -1);
    }

    public static void main(String[] args) {
        RangeModule rangeModule = new RangeModule();
        rangeModule.addRange(10, 20);
        rangeModule.removeRange(14, 16);
        rangeModule.queryRange(13, 14);
        rangeModule.queryRange(13, 15);
        rangeModule.queryRange(16, 17);
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
