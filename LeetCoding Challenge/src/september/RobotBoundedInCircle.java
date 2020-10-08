package september;
/*
https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3463/
 */
public class RobotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {
        int[] moves=new int[4];
        int currentDirection=0;
        for (int i = 0; i < instructions.length(); i++) {
            char ch=instructions.charAt(i);
            if(ch=='G')
            {
                if(currentDirection == 1 || currentDirection == 2)
                moves[currentDirection]--;
                else moves[currentDirection]++;
            }
            else if(ch=='L')
            {
                currentDirection = (3 + currentDirection) % 4;
            }
            else if(ch=='R')
            {
                currentDirection = (1 + currentDirection) % 4;
            }
        }
        boolean isPointingNorth = currentDirection == 0;
        boolean isMoved= (moves[0] + moves[2]) == 0 && (moves[1] + moves[3]) == 0;

        if(!isPointingNorth || isMoved)
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new RobotBoundedInCircle().isRobotBounded("GRGL"));
    }
}
