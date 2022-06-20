import java.util.ArrayList;
import java.util.List;

/*
 * @Author: whe
 * @Date: 2022-05-18 15:17:37
 */
public class OfferII63 {
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

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public int start(String prefix) {
            TrieNode p = root;
            for (int i = 0; i < prefix.length(); i++) {
                char w = prefix.charAt(i);
                if (p.child[w - 'a'] == null) {
                    return -1;
                }
                if (p.child[w - 'a'].isEnd) {
                    return i;
                }

                p = p.child[w - 'a'];
            }
            return -1;
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String d : dictionary) {
            trie.insert(d);
        }
        StringBuilder sb = new StringBuilder();
        String[] ss = sentence.split(" ");
        for (String s : ss) {
            int l = trie.start(s);
            if (l == -1) {
                sb.append(s);
                sb.append(" ");
            } else {
                sb.append(s.substring(0, l + 1));
                sb.append(" ");
            }
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    public static void main(String[] args) {
        OfferII63 test = new OfferII63();
        List<String> dictionary = new ArrayList<String>(){{
            add("cat");
            add("bat");
            add("rat");
        }};
        test.replaceWords(dictionary, "the cattle was rattled by the battery");
    }
}
