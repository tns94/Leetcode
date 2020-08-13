package july;

/*
https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3399/
 */
public class Single_Number_III {
    public int[] singleNumber(int[] nums) {
        int xor=0;
        int index=0;
        int[] answer=new int[2];
        for (int j:nums)
            xor ^= j;

        index=xor&(-xor);

        int xor2=0;
        for(int i:nums)
        {
            if((i&index)>0)
                xor2 ^= i;
        }
        answer[0]=xor2;
        answer[1]=xor^xor2;
        return answer;
    }

    public static void main(String[] args) {

        int[] ans=new Single_Number_III().singleNumber(new int[]{1,1,2,2,3,3,5,6});
        System.out.println(ans[0]+" "+ans[1]);
    }
}
