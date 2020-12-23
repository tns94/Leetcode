package november;
/*
https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/565/week-2-november-8th-november-14th/3527/
 */
public class ValidSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        if (p1[0] == p2[0] && p1[1] == p2[1]
                || p1[0] == p3[0] && p1[1] == p3[1]
                || p1[0] == p4[0] && p1[1] == p4[1]) return false;

        int d2=distSq(p1,p2);
        int d3=distSq(p1,p3);
        int d4=distSq(p1,p4);

        if(d4==0||d2==0||d3==0)
            return false;

        if (d2 == d3 && 2 * d2 == d4) {
            int d = distSq(p2, p4);
            return (d == distSq(p3, p4) && d == d2);
        }

        if (d3 == d4 && 2 * d3 == d2) {
            int d = distSq(p2, p3);
            return (d == distSq(p2, p4) && d == d3);
        }

        if (d2 == d4 && 2*d2 == d3) {
            int d = distSq(p2, p3);
            return (d == distSq(p3, p4) && d == d2);
        }

        return false;

    }
     int distSq(int[] p, int[] q)
    {
        return (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
    }
}
