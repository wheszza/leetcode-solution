/*
 * @Author: whe
 * @Date: 2022-06-20 14:58:04
 */
public class TreeArray {
    int[] arr;
    //n为原数组长加1
    public TreeArray(int n) {
        arr = new int[n];
    }
    public int lowbit(int x) {
        return x & (-x);
    }
    //id为原数组id+1
    public int query(int id) {
        int ans = 0;
        for (int i = id; i > 0; i = i - lowbit(i)) {
            ans += arr[i];
        }
        return ans;
    }
    public void add(int id, int val) {
        for (int i = id; i < arr.length; i = i + lowbit(i)) {
            arr[i] += val;
        }
    }
}
