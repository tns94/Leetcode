package september;

/*
https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/555/week-2-september-8th-september-14th/3454/
 */
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] version1Array=version1.split("\\.");
        String[] version2Array=version2.split("\\.");

        int len=Math.max(version1Array.length,version2Array.length);

        for (int i = 0; i < len; i++) {
            Integer v1=i>=version1Array.length?0:Integer.parseInt(version1Array[i]);
            Integer v2=i>=version2Array.length?0:Integer.parseInt(version2Array[i]);

            if(v1>v2)
                return 1;
            else if(v2>v1)
                return -1;
        }
        return 0;
    }
}
