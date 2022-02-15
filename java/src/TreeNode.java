/**
 * @Author whe
 * @Date 2022/2/15 16:58
 */


import java.util.LinkedList;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static String TreeToStr(TreeNode root) {
        StringBuffer ans = new StringBuffer();
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                TreeNode first = q.pollFirst();
                if (first != null) {
                    q.addLast(first.left);
                    q.addLast(first.right);
                    ans.append(Integer.toString(first.val));
                } else {
                    ans.append("null");
                }
                ans.append(" ");
            }
        }
        return ans.toString();
    }

    public static TreeNode StrToTree(String s) {
        String[] sArr = s.split(",");
        TreeNode[] treeArr = new TreeNode[sArr.length];
        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i].equals("null")) {
                treeArr[i] = new TreeNode();
            } else {
                treeArr[i] = new TreeNode(Integer.valueOf(sArr[i]));
            }
        }
        for (int i = 0; 2 * i + 2 < sArr.length; i++) {
            if (treeArr[i] != null) {
                treeArr[i].left = treeArr[2 * i + 1];
                treeArr[i].right = treeArr[2 * i + 2];
            }
        }
        return treeArr[0];
    }

    public static void main(String[] args) {
        System.out.println(TreeToStr(StrToTree("1")));
    }
}
