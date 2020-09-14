package august;

import java.util.ArrayList;

/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/552/week-4-august-22nd-august-28th/3434/
 */
public class StreamChecker {
    ArrayList<Character> queryList=new ArrayList<>();
    Trie trie;
    public StreamChecker(String[] words) {
        trie=new Trie(new Trie[26]);
       for(String word:words)
           addWord(word);
    }

    public boolean query(char letter) {
        queryList.add(letter);
       return searchHelper(queryList.size()-1,trie);
    }

    public boolean searchHelper(int index,Trie trieNode)
    {
        if(trieNode.leaf)
            return true;
        if(0>index)
            return false;

        int ind=queryList.get(index)-97;

        if(trieNode.chars[ind]==null)
            return false;
        else
            return searchHelper(index-1,trieNode.chars[ind]);
    }

    public void addWord(String word) {
        Trie cur=trie;
        for (int i = word.length()-1; i >=0; i--)
        {
            char c=word.charAt(i);
            int index=c-97;
            if(cur.chars==null)
                cur.chars = new Trie[26];
            if(cur.chars[index]!=null)
                cur=cur.chars[index];
            else {
                cur=cur.chars[index]=new Trie(c);
            }
        }
        cur.leaf=true;
    }
    static class Trie{
        char c;
        Trie[] chars;
        boolean leaf;
        Trie(Trie[] chars){
            this.chars=chars;
        }
        Trie(char c){this.c=c;}
    }

    public static void main(String[] args) {
        StreamChecker streamChecker=new StreamChecker(new String[]{"ab","ba","aaab","abab","baa"});
        streamChecker.query('a');          // return false
        streamChecker.query('a');          // return false
        streamChecker.query('c');          // return false
        streamChecker.query('d');          // return true, because 'cd' is in the wordlist
        streamChecker.query('e');          // return false
        streamChecker.query('f');          // return true, because 'f' is in the wordlist
        streamChecker.query('g');          // return false
        streamChecker.query('h');          // return false
        streamChecker.query('i');          // return false
        streamChecker.query('j');          // return false
        streamChecker.query('k');          // return false
        streamChecker.query('l');          // return true, because 'kl' is in the wordlist

    }
}
