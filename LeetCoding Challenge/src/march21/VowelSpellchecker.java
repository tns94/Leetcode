package march21;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/591/week-4-march-22nd-march-28th/3681/
 */
public class VowelSpellchecker {
    Set<String> perfectWords;
    Map<String, String> capWords;
    Map<String, String> vowelWOrds;

    public String[] spellchecker(String[] wordlist, String[] queries) {
        perfectWords = new HashSet<>();
        capWords = new HashMap<>();
        vowelWOrds = new HashMap<>();

        for (String word: wordlist) {
            perfectWords.add(word);

            String wordlow = word.toLowerCase();
            capWords.putIfAbsent(wordlow, word);

            String wordlowDV = maskVowel(wordlow);
            vowelWOrds.putIfAbsent(wordlowDV, word);
        }

        String[] ans = new String[queries.length];
        int t = 0;
        for (String query: queries)
            ans[t++] = solve(query);
        return ans;
    }

    public String solve(String query) {
        if (perfectWords.contains(query))
            return query;

        String queryL = query.toLowerCase();
        if (capWords.containsKey(queryL))
            return capWords.get(queryL);

        String queryLV = maskVowel(queryL);
        if (vowelWOrds.containsKey(queryLV))
            return vowelWOrds.get(queryLV);

        return "";
    }

    public String maskVowel(String word) {
        StringBuilder ans = new StringBuilder();
        for (char c: word.toCharArray())
            ans.append(isVowel(c) ? '*' : c);
        return ans.toString();
    }

    public boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
}
