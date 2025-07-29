package daily._2025_07;

public class _2210_CountHillsAndValleysInAnArray {
    public static void main(String[] args) {

    }

    public static int countHillValley(int[] nums) {
        int length = nums.length;
        int result = 0;
        boolean isIncreasing = false;
        int index = 1;
        while (index < length && nums[index] == nums[index - 1]) {
            index++;
        }
        if (index < length) {
            isIncreasing = nums[index] > nums[index - 1];
            index++;
        }
        while (index < length) {
            if (nums[index] > nums[index - 1]) {
                if (!isIncreasing) {
                    result++;
                }
                isIncreasing = true;
            } else if (nums[index] < nums[index - 1]) {
                if (isIncreasing) {
                    result++;
                }
                isIncreasing = false;
            }
            index++;
        }

        return result;
    }
}
