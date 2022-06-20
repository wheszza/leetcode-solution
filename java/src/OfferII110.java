import java.util.ArrayList;
import java.util.List;

/*
 * @Author: whe
 * @Date: 2022-06-15 19:41:17
 */
public class OfferII110 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> t = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfs(graph, 0);
        return ans;
    }
    private void dfs(int[][] graph, int u) {
        t.add(u);
        if (u == graph.length - 1) {
            ans.add(new ArrayList<>(t));
            t.remove(t.size() - 1);
            return;
        }
        for (int v : graph[u]) {
            dfs(graph, v);
        }
        t.remove(t.size() - 1);
    }

    public static void main(String[] args) {
        OfferII110 test = new OfferII110();
        int[][] graph = new int[][]{{1,2},{3},{3},{}};
        test.allPathsSourceTarget(graph);
    }
}
