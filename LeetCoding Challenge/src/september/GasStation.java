package september;
/*
https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/557/week-4-september-22nd-september-28th/3470/
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int startingPoint=0;
        int currentGas=0;
        int totalGas=0;
        int sumGas=0;

        for (int i = 0; i < gas.length; i++) {
            currentGas = gas[i]-cost[i];

            if(sumGas >= 0)
                sumGas += currentGas;
            else
            {
                sumGas = currentGas;
                startingPoint = i;
            }
            totalGas += currentGas;
        }
        
        return totalGas >= 0 ? startingPoint : -1;
    }

    public static void main(String[] args) {
        GasStation gasStation=new GasStation();
        int[] gas={6,1,4,3,5};
        int[] cost={3,8,2,4,2};
        int point=gasStation.canCompleteCircuit(gas,cost);
        System.out.println(point);
    }
}
