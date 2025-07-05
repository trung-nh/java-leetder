package neet_code.binary_search;

public class _153_FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {

    }

    public static int findMin(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            if (left == n - 1) break;
            int mid = left + (right - left) / 2;

            if (mid > 0 && nums[mid] < nums[mid - 1]) return nums[mid];

            if (nums[left] <= nums[mid] && nums[mid] < nums[right]) {
                return nums[left];
            }

            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return nums[left];
    }
}
