package neet_code.binary_search;

public class _33_SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int result = search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
    }

    public static int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (right - left == 1) {
                if(nums[right]==target) return right;
            }

            if (nums[left] < nums[right]) {
                if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] > nums[left] && nums[mid] > nums[right]) {
                if (nums[mid] > target) {
                    if (nums[left] <= target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target) {
                    if (nums[left] <= target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
