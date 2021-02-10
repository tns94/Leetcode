package january2021;
/*
https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/580/week-2-january-8th-january-14th/3600/
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1,j=n-1,k=m+n-1;
        while (j>=0)
        {
            if(i<0 || nums1[i]<=nums2[j])
                nums1[k--]=nums2[j--];
            else
                nums1[k--]=nums1[i--];
        }

        /*     Space - O(n)
        int[] arr=new int[m];
        for (int i = 0; i < m; i++) {
            arr[i]=nums1[i];
        }
        int i=0,j=0,k=0;
        while (i<m && j<n)
           nums1[k++]=arr[i]<nums2[j]?arr[i++]:nums2[j++];
        while (i<m)
            nums1[k++]=arr[i++];
        while (j<n)
            nums1[k++]=nums2[j++];*/
    }
}
