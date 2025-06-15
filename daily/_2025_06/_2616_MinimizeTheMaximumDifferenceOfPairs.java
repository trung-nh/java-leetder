package daily._2025_06;

import java.util.Arrays;

public class _2616_MinimizeTheMaximumDifferenceOfPairs {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int a = minimizeMax(arr, 3);
        System.out.println(5 + 5 / 2);
    }

    public static int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int left = 0;
        int n = nums.length;
        int right = nums[n - 1] - nums[0];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (countPairsWithThreshold(mid, nums, p) >= p) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static int countPairsWithThreshold(int threshold, int[] nums, int minPair) {
        int count = 0;
        int index = 0;
        while (index < nums.length - 1) {
            if (count >= minPair)
                break;
            if (nums[index + 1] - nums[index] <= threshold) {
                count++;
                index++;
            }
            index++;
        }
        return count;
    }

}