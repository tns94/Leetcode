package september;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3448/
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> list = new ArrayList<>();
        if (S == null || S.length() == 0)
            return list;

        int[] lastIndex = new int[26];
        char[] charArray=S.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            lastIndex[charArray[i] - 97] = i;
        }

        int co = 0;
        int maxIn = lastIndex[S.charAt(0) - 97];
        for (int i = 0; i < charArray.length; i++) {
            maxIn = Math.max(lastIndex[charArray[i] - 97] ,maxIn);
            co++;
            if (maxIn == i) {
                list.add(co);
                co = 0;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = new PartitionLabels().partitionLabels("ababcbacadefegdehijhklij");
        list.forEach(System.out::println);
    }
}
