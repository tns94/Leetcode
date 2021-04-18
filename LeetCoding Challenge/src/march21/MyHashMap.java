package march21;

import java.util.*;

/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/588/week-1-march-1st-march-7th/3663/
 */
public class MyHashMap {
    int[] hashMap;
    /** Initialize your data structure here. */
    public MyHashMap() {
        hashMap = new int[1000001];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
     hashMap[key]=value+1;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return hashMap[key] - 1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        hashMap[key]=0;
    }
}
