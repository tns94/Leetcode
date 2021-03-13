package february21;
/*
https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/586/week-3-february-15th-february-21st/3643/
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int i=0,j=height.length-1;
        int area=1;
        int width=j-i;
        while (i<j)
        {
            width=j-i;
            area=Math.max(area,width*(Math.min(height[i],height[j])));
            if(height[i]<height[j])
                i++;
            else j--;
        }
        return area;
    }
}
