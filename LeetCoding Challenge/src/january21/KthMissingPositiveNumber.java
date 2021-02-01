package january21;
/*
https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/579/week-1-january-1st-january-7th/3594/
 */
public class KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] - (mid + 1) >= k) right = mid - 1;
            else left = mid + 1;
        }
        return left + k;
    }

    public static void main(String[] args) {
        int[] arr={6,7,8,9};
        KthMissingPositiveNumber k=new KthMissingPositiveNumber();
        System.out.println(k.findKthPositive(arr,5));
    }
}
