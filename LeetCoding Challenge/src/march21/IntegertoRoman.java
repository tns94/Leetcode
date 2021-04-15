package march21;
/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/589/week-2-march-8th-march-14th/3667/
 */
public class IntegertoRoman {
    public String intToRoman(int num) {
        String[] sign={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] nums={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        StringBuilder ans=new StringBuilder();
        for (int i = 0; i < 13; i++) {
            while (num >= nums[i])
            {
                num -= nums[i];
                ans.append(sign[i]);
            }
        }
        return ans.toString();
    }
}
