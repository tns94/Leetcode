package september;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3467/
 */
public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        List<Location> list=new ArrayList<>();
        for (int i = 0; i < trips.length; i++) {
            list.add(new Location(trips[i][1],trips[i][0]));
            list.add(new Location(trips[i][2],-trips[i][0]));
        }
        list.sort((o1, o2) -> o1.point!=o2.point?o1.point-o2.point:o1.passengers-o2.passengers);
        int passengeOnBoard=0;
        for (Location location:list)
        {
            passengeOnBoard += location.passengers;
            if(passengeOnBoard > capacity)
                return false;
        }
        return true;
    }
    static class Location{
        int point;
        int passengers;

        public Location(int point, int passengers) {
            this.point = point;
            this.passengers = passengers;
        }
    }
}
