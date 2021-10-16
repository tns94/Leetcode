package april21;
/*
FlattenNestedListIterator
https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/594/week-2-april-8th-april-14th/3706/
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class NestedIterator implements Iterator<Integer> {

    List<Integer> list;
    int i;
    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<>();
        i=0;
        for (NestedInteger nestedInteger:nestedList)
            flattenList(nestedInteger);
    }

    void flattenList(NestedInteger nestedInteger)
    {
        if(nestedInteger.isInteger())
            list.add(nestedInteger.getInteger());
        else
        {
            for (NestedInteger nestedInteger1: nestedInteger.getList())
            {
                if(nestedInteger1.isInteger())
                    list.add(nestedInteger1.getInteger());
                else
                    flattenList(nestedInteger1);
            }
        }
    }

    @Override
    public Integer next() {
        if(hasNext())
            return list.get(i++);
        return null;//OR throw a Exception
    }

    @Override
    public boolean hasNext() {
        if(i>=list.size())
            return false;
        return true;
    }

}

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();
    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();
    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}