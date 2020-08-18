package july;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/548/week-5-july-29th-july-31st/3406/
 */

public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<String>> dp = new HashMap<>();
        return wordBreak(dp, s, s.length(), wordDict);
    }

    private List<String> wordBreak(Map<Integer, List<String>> dp, String s, int hi, List<String> wordDict) {
        List<String> answer = new ArrayList<>();

        if (hi == 0) {
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }

        if (dp.containsKey(hi)) {
            return dp.get(hi);
        }
        for (int lo = 0; lo < hi; lo++) {
            String sub = s.substring(lo, hi);
            if (wordDict.contains(sub)) {
                List<String> list = wordBreak(dp, s, lo, wordDict);
                for (String i : list) {
                    answer.add(i.length() == 0 ? sub : i + " " + sub);
                }
            }
        }
        dp.put(hi, answer);
        return answer;
    }
}

