package daily._2025_06;

import java.util.Arrays;

public class _2294_PartitionArraySuchThatMaximumDifferenceIsK {
    public static void main(String[] args) {
        System.out.println(partitionArray(new int[]{
                3, 6, 1, 2, 5
        }, 2));

    }

    // TC: O(n), SC: O(n)
    public static int partitionArray(int[] nums, int k) {
        int[] existed = new int[100001];
        int max = -1;
        int min = Integer.MAX_VALUE;
        int range = -1;
        int partitionCount = 0;
        for (int num : nums) {
            if (existed[num] != 1) {
                existed[num] = 1;
                max = Math.max(max, num);
                min = Math.min(min, num);
            }
        }

        for (int i = min; i <= max; i++) {
            if (existed[i] == 1) {
                if (i > range) {
                    range = i + k;
                    partitionCount++;
                }
            }
            if (max <= range) {
                break;
            }
        }

        return partitionCount;
    }

    // TC : O(nlogn)
    public static int partitionArray_(int[] nums, int k) {
        Arrays.sort(nums);
        int partitionCount = 1;
        int length = nums.length;
        int startPartition = nums[0];

        if (nums[length - 1] - nums[0] <= k) {
            return 1;
        }

        for (int num : nums) {
            if (num - startPartition > k) {
                startPartition = num;
                partitionCount++;
            }

        }
        return partitionCount;
    }
}
