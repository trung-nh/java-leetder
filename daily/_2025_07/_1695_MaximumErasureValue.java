package daily._2025_07;

import java.util.HashSet;
import java.util.Set;

public class _1695_MaximumErasureValue {
    public static void main(String[] args) {
        System.out.println(maximumUniqueSubarray_(new int[]{4, 2, 4, 5, 6}));
        System.out.println(maximumUniqueSubarray_(new int[]{5, 2, 1, 2, 5, 2, 1, 2, 5}));
    }

    public static int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        boolean[] seen = new boolean[10001];
        int left = 0;
        int currentSum = 0;
        int maxSum = 0;

        for (int right = 0; right < n; right++) {
            while (seen[nums[right]]) {
                currentSum -= nums[left];
                seen[nums[left]] = false;
                left++;
            }
            currentSum += nums[right];
            seen[nums[right]] = true;
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        return maxSum;
    }
    public static int maximumUniqueSubarray_(int[] nums) {
        int result = 0;
        int left = 0;
        int length = nums.length;
        int sum = 0;
        Set<Integer> set = new HashSet<>();

        for (int right = 0; right < length; right++) {
            if (set.contains(nums[right])) {
                result = Math.max(result, sum);
                sum += nums[right];
                while (left < right && nums[left] != nums[right]) {
                    sum -= nums[left];
                    set.remove(nums[left]);
                    left++;
                }
                sum -= nums[left];
                left++;
            } else {
                sum += nums[right];
                if (right == length - 1) {
                    return Math.max(result, sum);
                }
                set.add(nums[right]);
            }
        }
        return result;
    }
}
