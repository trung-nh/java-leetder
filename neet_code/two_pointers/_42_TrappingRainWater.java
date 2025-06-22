package neet_code.two_pointers;

public class _42_TrappingRainWater {
    public static void main(String[] args) {
    }

    public static int trap(int[] height) {
        int length = height.length;
        int left = 0;
        int right = length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int waterCount = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] < leftMax) {
                    waterCount += leftMax - height[left];
                } else {
                    leftMax = height[left];
                }
                left++;
            } else {
                if (height[right] < rightMax) {
                    waterCount += rightMax - height[right];
                } else {
                    rightMax = height[right];
                }
                right--;
            }
        }

        return waterCount;
    }

    public static int trap_(int[] height) {
        int waterCount = 0;
        int length = height.length;
        int[] water = new int[length];
        int currentMax = -1;

        // water[i] = max_to_the_left of each position [1, length-2]
        for (int i = 1; i < length - 1; i++) {
            currentMax = Math.max(currentMax, height[i - 1]);
            water[i] = currentMax;
        }
        currentMax = -1;

        // resolve water[i] = min(max_to_the_left, max_to_the_right)
        for (int i = length - 2; i > 0; i--) {
            currentMax = Math.max(currentMax, height[i + 1]);
            water[i] = Math.min(water[i], currentMax);
        }

        // resolve
        for (int i = 1; i < length - 1; i++) {
            waterCount += Math.max(water[i] - height[i], 0);
        }

        return waterCount;
    }
}
