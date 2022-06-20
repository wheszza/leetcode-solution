import java.util.*;

/*
 * @Author: whe
 * @Date: 2022-05-18 17:15:32
 */
public class OfferII64 {
    Map<Integer, ArrayList<String>> buckets;
    public OfferII64() {
        buckets = new HashMap<Integer, ArrayList<String>>();
    }

    public void buildDict(String[] words) {
        for (String word: words) {
            ArrayList<String> t = buckets.getOrDefault(word.length(), new ArrayList<>());
            buckets.put(word.length(), t);
        }
    }

    public boolean search(String word) {
        if (!buckets.containsKey(word.length())) return false;
        for (String candidate: buckets.get(word.length())) {
            int mismatch = 0;
            for (int i = 0; i < word.length(); ++i) {
                if (word.charAt(i) != candidate.charAt(i)) {
                    if (++mismatch > 1) break;
                }
            }
            if (mismatch == 1) return true;
        }
        return false;
    }
}
