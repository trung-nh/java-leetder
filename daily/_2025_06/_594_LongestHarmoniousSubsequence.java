package daily._2025_06;

import java.util.Arrays;

public class _594_LongestHarmoniousSubsequence {
    public static void main(String[] args) {

    }

    public static int findLHS(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int result = 0;
        int left = 0;

        while (left < n - 1) {
            int right = left;

            while (right < n && nums[right] - nums[left] == 0) {
                right++;
            }

            int nextLeft = right;

            while (right < n && nums[right] - nums[left] == 1) {
                right++;
            }

            if (nums[right - 1] - nums[left] == 1) {
                result = Math.max(result, right - left);
            }

            left = nextLeft;
        }

        return result;
    }
}
