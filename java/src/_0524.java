import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * @Author: whe
 * @Date: 2022-03-09 18:50:15
 */
class _0524 {

    //排序+双指针
    public String findLongestWord(String s, List<String> dictionary) {

        Collections.sort(dictionary, new Comparator<String>() {
            public int compare(String a, String b) {
                if (a.length() == b.length()) {
                    return a.compareTo(b);
                }
                return a.length() - b.length();
            }
        });

        String ans = "";

        for (String t : dictionary) {
            if (t.length() == ans.length())
                continue;
            if (prune(s, t))
                ans = t;
        }

        return ans;
    }

    // 双指针判断
    private boolean prune(String s, String t) {
        for (int i = 0, j = 0; i < t.length(); i++) {
            while (j < s.length() && s.charAt(j) != t.charAt(i)) {
                j++;
            }
            if (j == s.length())
                return false;
            j++;
        }
        return true;
    }

    
    public static void main(String[] args) {
        _0524 t = new _0524();
        String[] array = new String[]{"ale","apple","monkey","plea"};
        String ans = t.findLongestWord("apple", new ArrayList<String>(Arrays.asList(array)));
        if (ans.equals("apple")) {
            System.out.println("test pass");
        }
    }
}