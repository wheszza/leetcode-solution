/*
 * @Author: whe
 * @Date: 2022-06-09 16:10:41
 */
public class OfferII107 {
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] ans = new int[m][n];
        boolean[][] visit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != 0 && !visit[i][j]) {
                    dfs(mat, ans, visit, i, j);
                }
            }
        }
        return ans;
    }
    private int dfs(int[][] mat, int[][] ans, boolean[][] visit, int i, int j) {
        if (mat[i][j] == 0) return 0;
        visit[i][j] = true;
        int min = Integer.MAX_VALUE;
        for (int[] d : dirs) {
            int x = i + d[0];
            int y = j + d[1];
            if (check(mat, x, y) && !visit[i][j]) {
                min = Math.min(min, dfs(mat, ans, visit, x, y));
            }
        }
        if (min == Integer.MAX_VALUE) return min;
        ans[i][j] = min + 1;
        return min + 1;
    }

    private boolean check(int[][] mat, int i, int j) {
        if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        OfferII107 test = new OfferII107();
        test.updateMatrix(new int[][]{{0,0,0},{0,1,0},{0,0,0}});
    }
}
