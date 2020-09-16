package august;

/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3413/
 */


public class WordDictionary {

    Trie trie;
    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        trie=new Trie(new Trie[26]);
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        Trie cur=trie;
        for(Character c:word.toCharArray())
        {
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

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return searchHelper(trie,word.toCharArray(),0);
    }
    boolean searchHelper(Trie cur,char[] word,int st) {

        if (st == word.length)
        {
            if(cur.leaf)
            return true;
            else return false;
        }

        char c = word[st];
        if (cur.chars == null)
            return false;
        if (c == '.') {
            for (int i = 0; i < 26; i++)
                if (cur.chars[i] !=null && searchHelper(cur.chars[i], word, st + 1))
                    return true;
        } else if (cur.chars[c-97]!=null)
          return  searchHelper(cur.chars[c-97], word, st + 1);

        return false;
    }

    static class Trie{
        char ch;
        Trie[] chars;
        boolean leaf;
        Trie(char ch)
        {
            this.ch=ch;
        }
        Trie(Trie[] chars){
            this.chars=chars;
        }
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary=new WordDictionary();
        wordDictionary.addWord("bit");
        wordDictionary.addWord("a");wordDictionary.addWord("ab");
        wordDictionary.addWord("bad");
        wordDictionary.addWord("bay");

        System.out.println(wordDictionary.search("bad"));

    }
}
