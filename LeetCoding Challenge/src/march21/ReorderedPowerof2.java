package march21;


public class ReorderedPowerof2 {
    public boolean reorderedPowerOf2(int N) {
        int[] counterArray = new int[10];
        for (int i = N; i > 0; i /= 10) {
            counterArray[i % 10]++;
        }
        int powOf2 = 1;
        int count = 1;
        while (count < 32) {
            if (isCountMatch(powOf2, counterArray)) {
                return true;
            }
            powOf2 <<= 1;
            ++count;
        }
        return false;
    }

    private boolean isCountMatch(int n, int[] counterArray) {
        for (int i = n; i > 0; i /= 10) {
            --counterArray[i % 10];
        }
        boolean ans = true;
        for (int f : counterArray) {
            if (f != 0) {
                ans = false;
                break;
            }
        }
        for (int i = n; i > 0; i /= 10) {
            ++counterArray[i % 10];
        }
        return ans;
    }
}
