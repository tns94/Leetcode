package march21;
/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/588/week-1-march-1st-march-7th/3662/
 */
import java.util.Objects;

public class ShortEncodingofWords {
    class Trie{
        char ch;
        Trie[] children;
        boolean nonLeaf;

        public Trie(char ch) {
            this.ch = ch;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Trie trie = (Trie) o;
            return ch == trie.ch;
        }

        @Override
        public int hashCode() {
            return Objects.hash(ch);
        }
    }
    int add(Trie node,char[] s,int index)
    {
        if(index < 0 )
            return 0;
        int ret=0;
        int cur= s.length-index;
        Trie nod=new Trie(s[index]);
        if(node.children == null )
            node.children = new Trie[26];
        if(node.children[s[index]-97] == null) {
            node.children[s[index]-97] = nod;
            ret = 1;
            if(node.nonLeaf)
                ret += cur;
            node.nonLeaf = true;
        }

        ret += add(node.children[s[index]-97],s,index-1);
        return ret;
    }
    public int minimumLengthEncoding(String[] words) {
        int total=0;
        Trie node =new Trie('#');
        node.nonLeaf = true;
        for(String s:words)
            total += add(node,s.toCharArray(),s.length()-1);

        return total;
    }

    public static void main(String[] args) {
        String[] arr={"time", "me", "bell"};
        ShortEncodingofWords s=new ShortEncodingofWords();
        s.minimumLengthEncoding(arr);
    }
}
