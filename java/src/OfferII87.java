import java.util.ArrayList;
import java.util.List;

/*
 * @Author: whe
 * @Date: 2022-06-02 16:13:50
 */
public class OfferII87 {
    List<String> res;
    List<String> temp;// temp用于将原字符串截取分成四段

    public List<String> restoreIpAddresses(String s) {
        int n = s.length();
        res = new ArrayList<>();
        temp = new ArrayList<>();
        if (n <= 3 || n >= 13)
            return res;
        dfs(s, 0);
        return res;
    }

    public void dfs(String s, int begin) {
        if (begin == s.length() && temp.size() == 4) {
            String str = temp.get(0);
            for (int i = 1; i < 4; i++) {
                str = str + '.' + temp.get(i);
            }
            res.add(str);
            return;
        }
        if (begin < s.length() && temp.size() == 4) {
            return;
        }

        for (int len = 1; len <= 3; len++) {
            // 保证后续s.substring(begin,begin+len)合法
            if (begin + len - 1 >= s.length()) {
                return;
            }
            // 剔除不合法的前导0
            if (len != 1 && s.charAt(begin) == '0') {
                return;
            }
            // 截取字符串
            String st = s.substring(begin, begin + len);
            // 截取的字符串长度为3时，大小不能超过255
            if (len == 3 && Integer.parseInt(st) > 255) {
                return;
            }
            temp.add(st);
            dfs(s, begin + len);
            temp.remove(temp.size() - 1);
        }

    }

    public static void main(String[] args) {
        OfferII87 test = new OfferII87();
        test.restoreIpAddresses("25525511135");
    }
}
