package neet_code.two_pointers;

import java.util.Arrays;

public class _167_TwoSumIISorted {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{10, 20, 20, 30, 90}, 50)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 1;
        int right = numbers.length;
        while (left < right) {
            int sum = numbers[left - 1] + numbers[right - 1];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                break;
            }
        }
        return new int[]{left, right};
    }
}
