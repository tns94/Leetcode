package october;

import java.util.ArrayList;
import java.util.List;

public class RepeatedDNASequences {
    private static int hashCodeHelper(final Character c) {
        switch (c) {
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'G':
                return 2;
            case 'T':
                return 3;
            default:
                return -1;
        }
    }
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>(44);
        if (s.length() < 10) return ans;
        char[] chars = s.toCharArray();
        boolean[] hashCodeMap = new boolean[1048576];
        boolean[] added = new boolean[1048576];

        int hashCode = 0;
        int i = 0;
        for (; i < 10; i++) {
            hashCode = (hashCode << 2) + hashCodeHelper(chars[i]);
        }
        hashCodeMap[hashCode] = true;
        for (; i < chars.length; i++) {
            hashCode = ((hashCode << 2) & 1048575) + hashCodeHelper(chars[i]);
            if (hashCodeMap[hashCode] && !added[hashCode]) {
                ans.add(new String(chars,i-9,10));
                added[hashCode] = true;
            }
            hashCodeMap[hashCode] = true;
        }

        return ans;
    }
}
