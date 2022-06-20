import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
 * @Author: whe
 * @Date: 2022-05-18 15:30:29
 */
public class OfferII61 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums1.length && i < k; i++) {
            pq.add(new int[]{nums1[i] + nums2[0], i, 0});
        }
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            int[] min = pq.poll();
            int id1 = min[1];
            int id2 = min[2];
            ans.add(new ArrayList<Integer>(){{
                 add(nums1[id1]);
                 add(nums2[id2]);
            }});
            if (id2 + 1 < nums2.length) {
                pq.add(new int[]{nums1[id1] + nums2[id2 + 1], id1, id2 + 1});
            }
        }
        return ans;
    }
}
