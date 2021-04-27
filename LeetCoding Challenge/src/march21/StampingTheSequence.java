package march21;

import java.util.*;

/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/592/week-5-march-29th-march-31st/3691/
 */
public class StampingTheSequence {
    public int[] movesToStamp(String stamp, String target) {
        char[] s = stamp.toCharArray();
        char[] t = target.toCharArray();
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[t.length];
        int replacedStars = 0;

        while (replacedStars < t.length) {
            boolean replace = false;
            for (int i = 0; i <= t.length - s.length; i++) {
                if (!visited[i] && isMatch(s, t, i)) {
                    replacedStars += replaceAndGetCount(s, t, i);
                    replace = true;
                    visited[i] = true;
                    result.add(i);
                    if (replacedStars == t.length) {
                        break;
                    }
                }
            }
            if (!replace) return new int[0];
        }

        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(result.size() - i - 1);
        }
        return ans;
    }

    private boolean isMatch(char[] s, char[] t, int start) {
        for (int i = 0; i < s.length; i++) {
            if (t[i + start] != '*' && s[i] != t[i + start]) {
                return false;
            }
        }
        return true;
    }

    private int replaceAndGetCount(char[] s, char[] t, int start) {
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            if (t[i + start] != '*') {
                t[i + start] = '*';
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        StampingTheSequence s = new StampingTheSequence();
        for (int i : s.movesToStamp("abca", "aabcaca"))
            System.out.println(i);

    }
}
