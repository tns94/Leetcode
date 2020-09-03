package august;

/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/553/week-5-august-29th-august-31st/3442/
 */
public class LargestComponentSizebyCommonFactor {
    void union(int[] parent, int a, int b) {
        parent[find(parent, a)] = parent[find(parent, b)];


        /*   while(parent[a]!=a)
            a= parent[a];
        while(parent[b]!=b)
            b= parent[b];
        parent[b]=a;*/

    }

    int find(int[] parent, int a) {
        if (parent[a] != a) {
            parent[a] = find(parent, parent[a]);
        }
        return parent[a];

        /*  while(parent[a]!=a)
            a= parent[a];
        return a;*/
    }

    public int largestComponentSize(int[] A) {

        int maxEle = 0;
        for (int i = 0; i < A.length; i++) {
            maxEle = Math.max(maxEle, A[i]);
        }
        maxEle++;
        int[] parent = new int[maxEle];

        for (int i = 0; i < maxEle; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = 2; j <= Math.sqrt(A[i]); j++) {
                if (A[i] % j == 0) {
                    union(parent, A[i], j);
                    union(parent, A[i], A[i] / j);
                }
            }
        }

        int max = 1;
        int[] maxcount = new int[parent.length];
        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, ++maxcount[find(parent, A[i])]);
        }
        return max;

    }

    public static void main(String[] args) {
        LargestComponentSizebyCommonFactor lf = new LargestComponentSizebyCommonFactor();
        System.out.println(lf.largestComponentSize(new int[]{2, 3, 6, 7, 4, 12, 21, 39}));
    }
}
