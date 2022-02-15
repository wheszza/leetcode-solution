/**
 * @Author whe
 * @Date 2022/2/15 16:58
 */
public class _0124 {
    int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return result;
    }

    private int dfs(TreeNode root) {
        // 如果当前节点为叶子节点，那么对父亲贡献为 0
        if (root == null)
            return 0;
        // 如果不是叶子节点，计算当前节点的左右孩子对自身的贡献left和right
        int left = dfs(root.left);
        int right = dfs(root.right);
        // 更新最大值，就是当前节点的val 加上左右节点的贡献。
        result = Math.max(result, root.val + left + right);
        // 计算当前节点能为父亲提供的最大贡献，必须是把 val 加上！
        int max = Math.max(root.val + left, root.val + right);
        // 如果贡献小于0的话，直接返回0即可！
        return max < 0 ? 0 : max;
    }

    //test
    public static void main(String[] args) {
        _0124 test = new _0124();
        if (test.maxPathSum(TreeNode.StrToTree("1,2,3")) != 6) {
            System.out.print("error");
        }
        if (test.maxPathSum(TreeNode.StrToTree("-10,9,20,null,null,15,7")) != 42) {
            System.out.print("error");
        }
    }
}
