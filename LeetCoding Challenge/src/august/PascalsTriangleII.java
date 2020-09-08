package august;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3421/
 */

public class PascalsTriangleII {
    Integer[][] tri;
    {
        tri = new Integer[34][];
        for (int i = 0; i < 34; i++) {
            tri[i] = new Integer[i + 1];
            tri[i][0] = 1;
            for (int j = 1; j < i; j++) {
                tri[i][j] = tri[i - 1][j - 1] + tri[i - 1][j];
            }
            tri[i][i] = 1;
        }
    }

    public List<Integer> getRow(int rowIndex) {
        return Arrays.asList(tri[rowIndex]);
    }

    public static void main(String[] args) {
        System.out.println(new PascalsTriangleII().getRow(5));
    }
}
