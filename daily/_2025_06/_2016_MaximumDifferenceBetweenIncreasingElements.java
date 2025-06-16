package daily._2025_06;

public class _2016_MaximumDifferenceBetweenIncreasingElements {
    public static void main(String[] args) {

    }

    public int maximumDifference(int[] nums) {
        int maxDiff = -1;
        int small = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num < small) {
                small = num;
            } else if (num > small) {
                // small is reassigned at least once
                maxDiff = Math.max(num - small, maxDiff);
            } else {
                continue;
            }
        }

        return maxDiff;
    }
}
