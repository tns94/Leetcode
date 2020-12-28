package december;
/*
https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/571/week-3-december-15th-december-21st/3572/
 */
public class DecodedStringatIndex {
    public String decodeAtIndex(String S, int K) {
        long totalSize=0;
        for (int i = 0; i < S.length(); i++) {
            char ch=S.charAt(i);
            if(Character.isDigit(ch))
            {
                int num = ch - '0';
                totalSize*=num;
            }
            else
            {
                totalSize++;
            }
        }
        for (int i = S.length()-1; i >= 0; i--) {
            char ch=S.charAt(i);
            K%=totalSize;
            if((K==0 || K == totalSize) && Character.isLetter(ch))
                return String.valueOf(S.charAt(i));
            if(Character.isDigit(ch))
            {
                totalSize/=(ch-'0');
            }
            else
            {
                totalSize--;
            }

        }
        return "";
    }

    public static void main(String[] args) {
        new  DecodedStringatIndex().decodeAtIndex("a23",6);
    }
}
