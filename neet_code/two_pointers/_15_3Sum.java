package neet_code.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_3Sum {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        Arrays.sort(nums);

        for (int left = 0; left < length - 2; left++) {
            if (left > 0 && nums[left] == nums[left - 1]) {
                continue;
            }
            if (nums[left] + nums[left + 1] + nums[left + 2] > 0) {
                break;
            }

            int mid = left + 1;
            int right = length - 1;
            while (mid < right) {
                int sum = nums[left] + nums[mid] + nums[right];
                if (sum == 0) {
                    result.add(new ArrayList<>(Arrays.asList(nums[left], nums[mid], nums[right])));
                    while (mid + 1 < right && nums[mid] == nums[mid + 1]) {
                        mid++;
                    }
                    while (right - 1 > mid && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    mid++;
                    right--;
                } else if (sum < 0) {
                    mid++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}
