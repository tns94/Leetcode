package november;
/*
https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/566/week-3-november-15th-november-21st/3534/
 */
public class MirrorReflection {
    public int mirrorReflection(int p, int q) {
        while ((q&1)==0 && (p&1)==0)
        {
            q/=2;p/=2;
        }
        if((q&1)==0 && (p&1)==1) return 0;
        if((q&1)==1 && (p&1)==0) return 2;
        if((q&1)==1 && (p&1)==1) return 1;
        return -1;
    }
}
