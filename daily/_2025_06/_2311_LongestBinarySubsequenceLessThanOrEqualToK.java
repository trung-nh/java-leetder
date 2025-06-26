package daily._2025_06;

public class _2311_LongestBinarySubsequenceLessThanOrEqualToK {
    public static void main(String[] args) {
        System.out.println(longestSubsequence("1001010", 5));
    }

    public static int longestSubsequence(String s, int k) {
        int maxLength = 0;
        int sum = 0;
        char[] number = s.toCharArray();
        int length = number.length;
        boolean isSumMax = false;

        for (int i = length - 1; i >= 0; i--) {
            int digit = number[i] - '0';
            if (digit == 0) {
                maxLength++;
                continue;
            }
            if (!isSumMax) {
                int value = (int) Math.pow(2, length - 1 - i);
                // OVERFLOW-PRONE: Avoid using sum + value <= k
                if (k - sum >= value) {
                    sum += value;
                    maxLength++;

                } else {
                    isSumMax = true;
                }
            }
        }

        return maxLength;
    }
}
