package daily._2025_06;

import java.util.Arrays;

public class _2099_FindSubsequenceOfLengthKWithTheLargestSum {
    public static void main(String[] args) {

    }

    // 100%
    public static int[] maxSubsequence(int[] nums, int k) {
        int[] result = new int[k];
        int numCount = 0;
        int n = nums.length;
        int[] sortedNums = Arrays.copyOf(nums, n);
        Arrays.sort(sortedNums);
        int threshold = sortedNums[n - k];
        int thresholdCount = 0;

        for (int i = n - k; i < n; i++) {
            if (sortedNums[i] == threshold) {
                thresholdCount++;
            } else {
                break;
            }
        }

        for (int num : nums) {
            if (numCount < k) {
                if (num > threshold) {
                    result[numCount++] = num;
                }
                if (num == threshold && thresholdCount > 0) {
                    result[numCount++] = num;
                    thresholdCount--;
                }
            }
            if (numCount == k) break;
        }

        return result;
    }
}
