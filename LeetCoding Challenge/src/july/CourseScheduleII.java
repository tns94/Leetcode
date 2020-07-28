package july;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3394/
 */

/*
Detect Cycles in Directed Graph , if present return empty array
Topological sorting by DFS
 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        //Adjacancy List
        List<Integer>[] adjacancyList=new List[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {

            if(adjacancyList[prerequisites[i][1]]==null)
            {
                ArrayList<Integer> list=new ArrayList<>();
                list.add(prerequisites[i][0]);
                adjacancyList[prerequisites[i][1]]=list;
            }
            else
                adjacancyList[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        boolean whiteVisited[]=new boolean[numCourses];
        boolean blackVisited[]=new boolean[numCourses];
        boolean grayVisited[]=new boolean[numCourses];
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if(!whiteVisited[i])
            {
                if(DFS(adjacancyList,whiteVisited,blackVisited,grayVisited,stack,i))
                    return new int[]{};
            }
        }
        int[] ans=new int[numCourses];
        int i=0;
        while (!stack.empty())
        {
            ans[i++]=stack.pop();
        }
        for (int j = 0; j < numCourses; j++) {
            if(!whiteVisited[j])
                ans[i++]=j;
        }
        return ans;

    }
    boolean DFS(List<Integer>[] adjacancyList, boolean[] white,boolean[] black,boolean[] gray, Stack<Integer> stack,int vertex)
    {
        white[vertex]=true;
        gray[vertex]=true;
        if(adjacancyList[vertex]!=null)
        for (int i:adjacancyList[vertex])
        {
            if(gray[i])
                return true;
            if(!(black[i] || white[i]))
               if(DFS(adjacancyList,white,black,gray,stack,i))
                   return true;
        }
        gray[vertex]=false;
        black[vertex]=true;
        stack.push(vertex);
        return false;
    }

    public static void main(String[] args) {
        int [] ans=new CourseScheduleII().findOrder(2,new int[][]{{0,1},{1,0}});
        for (int an : ans) {
            System.out.println(an);
        }
    }
}
