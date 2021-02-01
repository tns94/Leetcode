package january21;
/*
https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/580/week-2-january-8th-january-14th/3599/
 */
public class CreateSortedArraythroughInstructions {
    static void update(int[] tree,int index,int num,int n)
    {
        while(index<=n)
        {
            tree[index]+=num;
            index+=index&(-index);
        }
    }
    static int query(int[] tree,int index,int n)
    {
        int sum=0;
        while(index>0)
        {
            sum+=tree[index];
            index-=index&(-index);
        }
        return sum;
    }
    public int createSortedArray(int[] instructions) {
        int sum=0;
        int n=100001;
        int[] fenwickTree=new int[n];
        for (int i = 0; i < instructions.length; i++) {
            int queryOneLess = query(fenwickTree,instructions[i]-1,n);
            int queryCurr = query(fenwickTree,instructions[i],n);
            int min = Math.min(queryOneLess,i-queryCurr);
            System.out.println("Insert "+instructions[i]+" with cost min("+queryOneLess+","+(i-queryCurr)+")-->"+min);
            sum = (sum + min) % 1000000007 ;
            update(fenwickTree,instructions[i],1,n);
        }
        return sum;
    }

    public static void main(String[] args) {
        CreateSortedArraythroughInstructions c=new CreateSortedArraythroughInstructions();
        int[] ins={1,2,3,6,5,4};
        System.out.println(c.createSortedArray(ins));
    }
}
