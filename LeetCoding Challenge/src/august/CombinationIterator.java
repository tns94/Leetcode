package august;

import java.util.Stack;
/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3422/
 */
public class CombinationIterator {
    static Stack<String> stack;
    static void createList(char[] chars,int mask,int l,int index)
    {
        if(l==0)
        {
            StringBuilder string=new StringBuilder();
            for (int i = 0; i < 16; i++) {
                if((1<<i & mask) >0)
                    string.append(chars[i]);
            }
            stack.push(string.toString());
            return;
        }
        if(index==chars.length)
            return;
        createList(chars,mask,l,index+1);
        createList(chars,mask | 1<<index,l-1,index+1);
    }
    public CombinationIterator(String characters, int combinationLength) {
        stack=new Stack<>();
        createList(characters.toCharArray(),0,combinationLength,0);
    }

    public String next() {
        return stack.pop();
    }

    public boolean hasNext() {
        return !stack.empty();
    }

    public static void main(String[] args) {
        CombinationIterator iterator=new CombinationIterator("abc",2);
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }
}
