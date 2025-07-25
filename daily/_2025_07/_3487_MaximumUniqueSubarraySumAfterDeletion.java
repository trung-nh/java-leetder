package daily._2025_07;

import java.util.HashSet;
import java.util.Set;

public class _3487_MaximumUniqueSubarraySumAfterDeletion {
    public static void main(String[] args) {

    }

    public static int maxSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            max = Math.max(max, num);
            if (num > 0 && !set.contains(num)) {
                sum += num;
                set.add(num);
            }
        }

        return sum == 0 ? max : sum;
    }
}
