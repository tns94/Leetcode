package november;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/567/week-4-november-22nd-november-28th/3540/
 */
public class UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseCode={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set=new HashSet<>();
        for(String word:words)
        {
            StringBuilder str=new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                str.append(morseCode[word.charAt(i)-97]);
            }
            set.add(str.toString());
        }
        return set.size();
    }
}
