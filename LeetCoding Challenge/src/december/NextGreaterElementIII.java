package december;
/*
https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/572/week-4-december-22nd-december-28th/3578/
 */
public class NextGreaterElementIII {
    public int nextGreaterElement(int n) {
        char[] digits = Integer.toString(n).toCharArray();
        int i = digits.length - 2;
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }
        if (i == -1) {
            return -1;
        }

        int j = digits.length - 1;
        while (digits[j] <= digits[i]) {
            j--;
        }
        swap(digits, i, j);
        reverse(digits, i + 1, digits.length - 1);

        try {
            return Integer.parseInt(new String(digits));
        } catch (Exception e) {
            return -1;
        }
    }

    private void swap(char[] digits, int i, int j) {
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
    }

    private void reverse(char[] digits, int from, int to) {
        while (from < to) {
            swap(digits, from++, to--);
        }
    }
}
