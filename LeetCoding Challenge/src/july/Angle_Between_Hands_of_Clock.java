package july;

/*
https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3390/
 */
public class Angle_Between_Hands_of_Clock {
    public double angleClock(int hour, int minutes) {
        double hourAngle=minutes/2.0;
        hourAngle+=((30.0*hour)%360);
        double minuteAngle=6.0*minutes;
        double angle = Math.abs(hourAngle-minuteAngle);
        return Math.min(angle,360-angle);

    }

    public static void main(String[] args) {
        System.out.println(new Angle_Between_Hands_of_Clock().angleClock(1,57));
    }
}
