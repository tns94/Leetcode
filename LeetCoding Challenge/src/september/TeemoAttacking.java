package september;

public class TeemoAttacking {
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int total = 0;
        int previousTime = -1;
        for(int n:timeSeries)
        {
            int currentPoisionRange=n+duration-1;
            if(previousTime >= n)
                total += currentPoisionRange - previousTime;
            else
                total+=duration;
            previousTime = currentPoisionRange;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(findPoisonedDuration(new int[]{1,2},4));
    }
}
