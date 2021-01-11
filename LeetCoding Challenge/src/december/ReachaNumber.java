package december;

/*
https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/572/week-4-december-22nd-december-28th/3583/
 */
public class ReachaNumber {
    //Optmized (Math trick)
    static int reachNumber(int target)
    {
        target = Math.abs(target);
        int sum = 0, step = 0;

        while (sum < target || (sum - target) % 2
                != 0) {
            step++;
            sum += step;
        }
        return step;
    }
    /*DFS
    static int reach(int source, int step, int dest) {
        if (Math.abs(source) > (dest))
            return Integer.MAX_VALUE;

        if (source == dest)
            return step;


        int pos = reach(source + step + 1,
                step + 1, dest);

        int neg = reach(source - step - 1,
                step + 1, dest);

        return Math.min(pos, neg);
    }*/
    public static void main(String[] args) {
        ReachaNumber reachaNumber=new ReachaNumber();
        System.out.println(reachaNumber.reachNumber(12313223));
    }
}
