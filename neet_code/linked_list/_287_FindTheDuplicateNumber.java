package neet_code.linked_list;

public class _287_FindTheDuplicateNumber {
    public static void main(String[] args) {

    }

    public static int findDuplicate(int[] nums) {
        if (nums.length < 3) return nums[0];

        int slow = nums[0];
        int fast = nums[nums[0]];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
