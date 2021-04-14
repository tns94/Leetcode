package march21;

import java.util.Random;

/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/590/week-3-march-15th-march-21st/3675/
 */
public class GenerateRandomPointinaCircle {
    double radius,  x_center,  y_center;
    Random rand=null;

    public GenerateRandomPointinaCircle(double radius, double x_center, double y_center) {
        this.radius =radius;
        this.x_center=x_center;
        this.y_center=y_center;
        rand=new Random();
    }

    public double[] randPoint() {
        double[] ans=new double[2];
        double x = (rand.nextDouble() * 2*radius ) + x_center - radius;
        double y = (rand.nextDouble() * 2*radius ) + y_center - radius;

      while ( (x_center - x) * (x_center - x) + (y_center - y) * (y_center - y) >= radius * radius)
       {
            x = (rand.nextDouble() * 2*radius ) + x_center - radius;
            y = (rand.nextDouble() * 2*radius ) + y_center - radius;
       }
       ans[0]=x;
       ans[1]=y;
       return ans;
    }
}
