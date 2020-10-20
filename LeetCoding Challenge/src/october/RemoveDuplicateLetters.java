package october;
/*
https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/560/week-2-october-8th-october-14th/3491/
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        boolean[] present=new boolean[26];
        int[] frequency=new int[26];
        for (char ch:s.toCharArray())
            frequency[ch-97]++;

        StringBuilder answer=new StringBuilder();
        char lastChar='0';
        answer.append('0');
        for (char ch:s.toCharArray())
        {
            frequency[ch-97]--;
            if(!present[ch-97])
            {
                while (lastChar > ch && frequency[lastChar-97] > 0)
                {
                    answer.deleteCharAt(answer.length()-1);
                    present[lastChar-97]=false;
                    lastChar=answer.charAt(answer.length()-1);
                }
                answer.append(ch);
                present[ch-97]=true;
                lastChar=ch;
            }
        }
        return answer.substring(1);
    }

    public static void main(String[] args) {
        RemoveDuplicateLetters removeDuplicateLetters=new RemoveDuplicateLetters();
        System.out.println(removeDuplicateLetters.removeDuplicateLetters("cbacdcbc"));
    }
}
