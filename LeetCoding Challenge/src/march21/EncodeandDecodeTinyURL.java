package march21;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/590/week-3-march-15th-march-21st/3673/
 */
public class EncodeandDecodeTinyURL {
    Map<String, String> map;
    int counter = 1000000000;
    static String digits = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_";

    EncodeandDecodeTinyURL(){
        map = new HashMap<>();
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        --counter;
        String url = base64(counter);
        map.put(url, longUrl);
        return url;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }

    public String base64(int val) {
        StringBuffer sb = new StringBuffer();

        while(val>0) {
            int digit = val%64;
            val = val/64;
            sb.append(digits.charAt(digit));
        }
        return sb.toString();
    }
}
