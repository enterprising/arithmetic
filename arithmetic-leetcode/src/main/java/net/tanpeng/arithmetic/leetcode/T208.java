package net.tanpeng.arithmetic.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by peng.tan on 2021/4/14 10:34 下午
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 */
public class T208 {

    private Set<String> sets;

    /**
     * Initialize your data structure here.
     */
    public T208() {
        sets = new HashSet<>();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        sets.add(word);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        return sets.contains(word);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        AtomicBoolean result = new AtomicBoolean(false);
        sets.forEach(i -> {
            if (i.startsWith(prefix)) {
                result.set(true);
                return;
            }
        });
        return result.get();
    }
}
