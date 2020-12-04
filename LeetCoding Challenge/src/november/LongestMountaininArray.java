package november;
/*
https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/566/week-3-november-15th-november-21st/3533/
 */
public class LongestMountaininArray {
    public static int longestMountain(int[] A) {
        if(A == null || A.length < 3)
            return 0;
        int n=A.length;
        int base=0,ans=0;
        while (base < n)
        {
            int end=base;
            if(end + 1 < n && A[end] < A[end+1])
            {
                //uphill
                while (end + 1 < n && A[end] < A[end+1]) end++;

                if(end + 1 < n && A[end] > A[end+1])
                {
                    //downhill
                    while (end + 1 < n && A[end] > A[end+1]) end++;
                    ans=Math.max(ans,end-base+1);
                }
            }
            base = Math.max(end, base + 1);
        }
        return ans;



/*
        2 pass method
        int[] inc=new int[A.length];
        int prev =A[0];
        inc[0]=1;
        for (int i = 1; i < A.length; i++) {
            if(prev < A[i])
                inc[i]=inc[i-1]+1;
            else
                inc[i]=1;
            prev=A[i];
        }
        prev =A[A.length-1];
        int counter=1;
        int result=0;
        for (int i = A.length-2; i >= 0; i--) {
            if(prev < A[i])
                counter++;
            else if(prev > A[i])
            {
                if(counter>1)
                 result = Math.max(result,counter+inc[i]);
                counter=1;
            }
            else
                counter=1;
            prev=A[i];
        }
        return result>2?result:0;

 */
    }

    public static void main(String[] args) {
        int[] input= {2,3,3,2,0,2};
        System.out.println(longestMountain(input));
    }
}
