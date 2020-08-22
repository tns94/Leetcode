package august;

import java.awt.image.BandedSampleModel;

/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3419/
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int sum =0;
        for(char c: s.toCharArray()){
            sum = sum *26 + (c - 64);
        }
        return sum;
    }

  /*  int[] columnCount;
    int[] power;

    {
        columnCount = new int[7];
        power=new int[6];
        columnCount[0] = 0;
        columnCount[1] = 26;

        power[0] = 26;
        for (int i = 2; i < 7; i++) {
            power[i-1]=power[i-2]*26;
            columnCount[i] = power[i-1] + columnCount[i - 1];
        }
    }

    public int titleToNumber(String s) {

        int length = s.length();
        int answer=(s.charAt(length-1)-'A')+1;
        int j=0;
        for (int i = length-2; i >= 0 ; i--) {
            answer+=power[j++]*(s.charAt(i)-'A');
        }
        return answer+columnCount[length-1];
    }
*/
  public static void main(String[] args) {
      System.out.println(new ExcelSheetColumnNumber().titleToNumber("ZZY"));
  }
}
