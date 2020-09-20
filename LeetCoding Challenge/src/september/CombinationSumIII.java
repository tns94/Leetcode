package september;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/555/week-2-september-8th-september-14th/3457/
 */
public class CombinationSumIII {

    List<List<Integer>> answer;
    void getCombinations(List<Integer> list,int num, int sum, int n, int k)
    {
        if(sum==n && list.size()==k)
        {
            List<Integer> tempList=new ArrayList<>(list);
            tempList.remove(0);
            tempList.add(num);
            answer.add(tempList);
        }
        if(sum>n || list.size()>=k)
            return;


        list.add(num);
        for (int i = num+1; i <= 9; i++) {
            getCombinations(list,i,sum+i,n,k);
        }
        list.remove(list.size()-1);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        answer=new ArrayList<>();
        getCombinations(new ArrayList<>(),0,0,n,k);
        return answer;
    }

    public static void main(String[] args) {
        CombinationSumIII combinationSumIII=new CombinationSumIII();
        List<List<Integer>> combinations= combinationSumIII.combinationSum3(3,9);
        for(List<Integer> list:combinations)
        {
            list.forEach(System.out::print);
            System.out.println();
        }
    }
}
