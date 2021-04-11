package march21;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/590/week-3-march-15th-march-21st/3678/
 */
public class DesignUndergroundSystem {
    class Passenger{
        int startTime;
        int endTime;
        String startStation;
        String endStation;

        public Passenger(String startStation,int startTime){
            this.startStation  = startStation;
            this.startTime = startTime;
        }

        void checkout(String endStation, int endTime) {
            this.endTime = endTime;
            this.endStation = endStation;
        }
    }


    class Route {

        int tripCount;
        long totalTravelTime;

        public Route() {
        }

        double getAverageTime() {
            return (double) totalTravelTime / tripCount;
        }

        void addTrip(int travelDuration) {
            totalTravelTime += travelDuration;
            tripCount += 1;
        }
    }
    Map<Integer, Passenger> passengerMap = null;
    Map<String, Route> routeMap = null;

    public DesignUndergroundSystem() {
        routeMap =new HashMap<>();
        passengerMap = new HashMap();
    }

    public void checkIn(int id, String stationName, int t) {
        if(!passengerMap.containsKey(id)){
            Passenger newTraveller = new Passenger(stationName, t);
            passengerMap.put(id, newTraveller);
        }
    }

    public void checkOut(int id, String stationName, int t) {
        if(passengerMap.containsKey(id)){
            Passenger oldTraveller = passengerMap.get(id);
            oldTraveller.checkout(stationName, t);
            String routeKey  = oldTraveller.startStation + "_" + oldTraveller.endStation;

            Route routeDetails = routeMap.getOrDefault(routeKey, new Route());
            int duration = oldTraveller.endTime -oldTraveller.startTime;
            routeDetails.addTrip(duration);
            routeMap.put(routeKey, routeDetails);
            passengerMap.remove(id);
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        String routeKey  = startStation + "_" + endStation;
        Route routeDetails = routeMap.get(routeKey);
        return routeDetails.getAverageTime();
    }
}
