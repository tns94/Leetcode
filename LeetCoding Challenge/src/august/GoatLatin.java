package august;

/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3429/
 */
public class GoatLatin {
    public String toGoatLatin(String S) {
        String[] tokens=S.split("\\s+");
        StringBuilder answer=new StringBuilder();
        StringBuilder a=new StringBuilder("a");
        for (String s:tokens)
        {
            char firstChar=s.charAt(0);
            if(firstChar=='a' ||firstChar=='e' ||firstChar=='i' ||firstChar=='o' ||firstChar=='u' ||
            firstChar=='A' ||firstChar=='E' ||firstChar=='I' ||firstChar=='O' ||firstChar=='U')
            {
                answer.append(s).append("ma").append(a);
            }
            else {
                answer.append(s.substring(1)).append(firstChar).append("ma").append(a);
            }
            answer.append(" ");
            a.append("a");
        }
        return answer.deleteCharAt(answer.length()-1).toString();
    }
}
