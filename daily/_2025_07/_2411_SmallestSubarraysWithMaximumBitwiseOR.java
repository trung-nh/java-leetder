package daily._2025_07;

import java.util.Arrays;

public class _2411_SmallestSubarraysWithMaximumBitwiseOR {
    public static void main(String[] args) {

    }

    public static int[] smallestSubarrays(int[] nums) {
        int length = nums.length;
        int[] position = new int[31];
        Arrays.fill(position, -1);
        int[] answer = new int[length];

        for (int i = length - 1; i >= 0; --i) {
            int j = i;
            for (int bit = 0; bit < 31; ++bit) {
                if ((nums[i] & (1 << bit)) == 0) {
                    if (position[bit] != -1) {
                        j = Math.max(j, position[bit]);
                    }
                } else {
                    position[bit] = i;
                }
            }
            answer[i] = j - i + 1;
        }
        return answer;
    }
}
