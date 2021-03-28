package february21;

import java.util.Stack;

/*
https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/584/week-1-february-1st-february-7th/3629/
 */
public class SimplifyPath {
    public static String simplifyPath(String path) {
        String[] dirs=path.split("/+");
        StringBuilder canonicalPath=new StringBuilder();
        int count=0;
        int i = dirs.length-1;
        while (i >= 0) {
            String dir=dirs[i];
            if(dir.isEmpty() || dir.equals("."))
            {
                i--;
                continue;
            }
            if(dir.equals(".."))
            {
                count++;
            }
            else if(count > 0)
                count--;
            else
            {
                canonicalPath.insert(0,dir).insert(0,"/");
            }
            i--;
        }

        return canonicalPath.length()==0?"/":canonicalPath.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/a/./b/../../c/"));
    }
}
