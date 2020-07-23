package july;

/*
https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3395/
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        if(a==null || b==null)
            return "";
        if(a.length()<b.length())
            return add(a,b);
        else
            return add(b,a);
    }
    String add(String a,String b)
    {
        byte carry=0;
        StringBuilder ans=new StringBuilder();
        int diff=(b.length()-a.length());
        for (int i = b.length()-1; i >= diff; i--) {
            int aBit=a.charAt(i-diff)-48;
            int bBit=b.charAt(i)-48;

            int sum=aBit + bBit + carry;
            if(sum==0)
            {
                carry=0;
                ans.append(0);
            }
            else if(sum==1)
            {
                carry=0;
                ans.append(1);
            }
            else if(sum==2)
            {
                carry=1;
                ans.append(0);
            }
            else if(sum==3)
            {
                carry=1;
                ans.append(1);
            }

        }
        while (carry==1 && --diff >=0){
            int bBit=b.charAt(diff)-48;
            int sum=bBit + carry;
            if(sum==0)
            {
                carry=0;
                ans.append(0);
            }
            else if(sum==1)
            {
                carry=0;
                ans.append(1);
            }
            else if(sum==2)
            {
                carry=1;
                ans.append(0);
            }
        }
        if(carry==1)
            ans.append(1);

        ans=ans.reverse();
        if(diff>=0)
            ans.insert(0,b.substring(0,diff));

    return ans.toString();
    }
    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("1","111"));
    }
}
