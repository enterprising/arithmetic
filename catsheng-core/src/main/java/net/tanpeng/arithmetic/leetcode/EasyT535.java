package net.tanpeng.arithmetic.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by peng.tan on 17/10/22.
 */
public class EasyT535 {
    private Map<Integer, String> map = new HashMap<>();
    private int i = 0;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        map.put(i, longUrl);
        i++;
        return "https://tinyurl.com/" + i;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(Integer.parseInt(shortUrl.replaceAll("https://tinyurl.com/", "")));
    }
}
