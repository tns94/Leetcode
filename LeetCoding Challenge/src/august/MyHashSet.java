package august;

/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3410/
 */
public class MyHashSet {

    boolean[] hash;
    /** Initialize your data structure here. */
    public MyHashSet() {
        hash=new boolean[1000000];
    }

    public void add(int key) {
        hash[key]=true;
    }

    public void remove(int key) {
        hash[key]=false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return hash[key];
    }
}