/*
 * @Author: whe
 * @Date: 2022-03-01 10:49:48
 */
public class _0006 {
    public String convert(String s, int numRows) {
        StringBuffer ans = new StringBuffer();
        char[] sArray = s.toCharArray();
        if (numRows == 1) {
            return s;
        }
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows - 1) {
                for (int j = i; j < s.length(); j += 2 * (numRows - 1)) {
                    ans.append(sArray[j]);
                }
            } else {
                for (int j = i; j < s.length(); j += 2 * (numRows - 1)) {
                    ans.append(sArray[j]);
                    int n = j + 2 * numRows - 2 - j % (2 * numRows - 2) * 2;
                    if (n < s.length()) {
                        ans.append(sArray[n]);
                    }
                }
            }
        }
        return ans.toString();
    }
}
