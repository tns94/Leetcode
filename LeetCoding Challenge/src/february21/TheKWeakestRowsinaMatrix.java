package february21;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/586/week-3-february-15th-february-21st/3641/
 */
public class TheKWeakestRowsinaMatrix {
    class Pair{
        int index, count;

        public Pair(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        List<Pair> list=new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            list.add(new Pair(i,countSoldier(mat[i])));
        }
        list.sort((o1, o2) -> o1.count == o2.count?o1.index-o2.index: o1.count-o2.count);
        int[] ans=new int[k];
        for (int i = 0; i < k; i++) {
            ans[i]=list.get(i).index;
        }
        return ans;
    }
    int countSoldier(int[] mat)
    {
        int i = 0,j= mat.length-1;
        while (i <= j)
        {
            int mid=i + (j-i)/2;
            if(mat[mid]==0){
                if(mid == 0|| mat[mid-1]==1)
                    return mid;
                j=mid-1;
            }
            else{
                if(mid==mat.length-1 || mat[mid+1]==0)
                    return mid+1;
                i=mid+1;
            }
        }
        return i;
    }
}
