package november;

import java.util.*;

/*
https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/567/week-4-november-22nd-november-28th/3546/
 */
public class SlidingWindowMaximum {
    static int rangeQuery(int[] tree,int treeIn,int st,int en, int l,int r)
    {
        if(st>=l && en<=r)
            return tree[treeIn];
        if (en<l || st>r)
            return Integer.MIN_VALUE;
        int mid=(st+en)/2;
        return Math.max(rangeQuery(tree,2*treeIn,st,mid,l,r)
                ,
                rangeQuery(tree,2*treeIn+1,mid+1,en,l,r));
    }

    static void buildTree(int[] arr,int[] tree,int treeIn, int st, int en)
    {
        if(st==en)
        {
            tree[treeIn]=arr[st];
            return;
        }
        int mid=(st+en)/2;

        buildTree(arr,tree,treeIn*2,st,mid);
        buildTree(arr,tree,treeIn*2+1,mid+1,en);

        tree[treeIn]=Math.max(tree[2*treeIn],tree[2*treeIn+1]);
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k<2)
            return nums;
        int n=nums.length;
        int[] tree=new int[4*n];
        buildTree(nums,tree,1,0,n-1);
        int[] answer=new int[n-(k-1)];
        int g=0;
        for (int i = 0; i <= n-k; i++) {
            answer[g++]=rangeQuery(tree,1,0,n-1,i,i+k-1);
        }
        return answer;
    }
}
