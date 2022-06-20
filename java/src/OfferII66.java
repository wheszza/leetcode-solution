
/*
 * @Author: whe
 * @Date: 2022-05-19 15:55:07
 */
import java.util.*;

public class OfferII66 {
    class Trie {

        class TrieNode {
            boolean isEnd;
            TrieNode[] child = new TrieNode[26];
        }

        TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode p = root;
            for (char w : word.toCharArray()) {
                if (p.child[w - 'a'] == null) {
                    p.child[w - 'a'] = new TrieNode();
                }
                p = p.child[w - 'a'];
            }
            p.isEnd = true;
        }

        /** Returns if the word is in the trie. */
        public List<String> search(String word) {
            List<String> ans = new ArrayList<>();
            TrieNode p = root;
            for (char w : word.toCharArray()) {
                if (p.child[w - 'a'] == null) {
                    return ans;
                }
                p = p.child[w - 'a'];
            }
            StringBuilder sb =  new StringBuilder();
            sb.append(word);
            dfs(ans, p, sb);
            return ans;
        }

        public void dfs(List<String> ans, TrieNode p, StringBuilder sb) {
            if (p.isEnd) {
                ans.add(sb.toString());
            }
            for (int i = 0; i < 26; i++) {
                if (p.child[i] != null) {
                    char c = (char) ('a' + i);
                    sb.append(c);
                    dfs(ans, p.child[i], sb);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }

    Trie trie;
    HashMap<String, Integer> map;

    /** Initialize your data structure here. */
    public OfferII66() {
        trie = new Trie();
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        trie.insert(key);
        map.put(key, val);
    }

    public int sum(String prefix) {
        int ans = 0;
        for (String s : trie.search(prefix)) {
            ans += map.get(s);
        }
        return ans;
    }

    public static void main(String[] args) {
        OfferII66 test = new OfferII66();
        test.insert("aa", 3);
        test.sum("a");
        test.insert("ab", 2);
        test.sum("a");
    }
}
