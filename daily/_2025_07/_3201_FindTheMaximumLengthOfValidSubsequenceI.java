package daily._2025_07;

public class _3201_FindTheMaximumLengthOfValidSubsequenceI {
    public static void main(String[] args) {
        maximumLength(new int[]{1, 2, 1, 1, 2, 1, 2});
    }

    public static int maximumLength(int[] nums) {
        int[] count = new int[2];
        int[] end = new int[2];
        for (int num : nums) {
            int parity = num % 2;
            count[parity]++;
            end[parity] = end[1 - parity] + 1;
        }

        return Math.max(
                Math.max(count[0], count[1]),
                Math.max(end[0], end[1])
        );
    }

    public static int maximumLength_(int[] nums) {
        int result = 1;
        int n = nums.length;
        int count = 0;
        boolean isLastNumEven = true;

        // case 1: full odd
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 1) {
                count++;
            }
        }

        // case 2: full even
        result = Math.max(count, n - count);

        // case 3: (odd-even) alternate
        count = 0;
        for (int i = 0; i < n; i++) {
            if (isLastNumEven && nums[i] % 2 == 1) {
                count++;
                isLastNumEven = false;
            } else if (!isLastNumEven && nums[i] % 2 == 0) {
                count++;
                isLastNumEven = true;
            }
            System.out.println("i=" + i + "  " + count);
        }
        result = Math.max(count, result);

        // case 4: (even-odd) alternate
        isLastNumEven = false;
        count = 0;
        for (int i = 0; i < n; i++) {
            if (isLastNumEven && nums[i] % 2 == 1) {
                count++;
                isLastNumEven = false;
            } else if (!isLastNumEven && nums[i] % 2 == 0) {
                count++;
                isLastNumEven = true;
            }
        }
        result = Math.max(count, result);

        return result;
    }
}
