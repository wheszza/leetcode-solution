/*
 * @Author: whe
 * @Date: 2022-02-28 22:25:36
 */

public class _0301 {
    int len;
    char[] charArray;
    int max;
    private Set<String> validExpressions = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        this.len = s.length();
        this.charArray = s.toCharArray();

        int leftRemove = 0;
        int rightRemove = 0;
        for (int i = 0; i < len; i++) {
            if (charArray[i] == '(') {
                leftRemove++;
            } else if (charArray[i] == ')') {
                if (leftRemove == 0) {
                    rightRemove++;
                }
                if (leftRemove > 0) {
                    leftRemove--;
                }
            }
        }
        int c1 = 0, c2 = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') c1++;
            else if (c == ')') c2++;
        }
        max = Math.min(c1, c2);
        String path = "";
        dfs(0, 0, 0, leftRemove, rightRemove, path, 0);
        return new ArrayList<>(this.validExpressions);
    }

    private void dfs(int index, int leftCount, int rightCount, int leftRemove, int rightRemove, String path, int score) {
        if (score < 0 || score > max) return ;
        if (index == len) {
            if (leftRemove == 0 && rightRemove == 0) {
                validExpressions.add(path);
            }
            return;
        }

        char character = charArray[index];
        if (character == '(' && leftRemove > 0) {
            dfs(index + 1, leftCount, rightCount, leftRemove - 1, rightRemove, path, score);
        }
        if (character == ')' && rightRemove > 0) {
            dfs(index + 1, leftCount, rightCount, leftRemove, rightRemove - 1, path, score);
        }
        //path.append(character);
        if (character != '(' && character != ')') {
            dfs(index + 1, leftCount, rightCount, leftRemove, rightRemove, path + character, score);
        } else if (character == '(') {
            dfs(index + 1, leftCount + 1, rightCount, leftRemove, rightRemove, path + character, score + 1);
        } else if (rightCount < leftCount) {
            dfs(index + 1, leftCount, rightCount + 1, leftRemove, rightRemove,path + character, score - 1);
        }
        //path.deleteCharAt(path.length() - 1);
    }
}