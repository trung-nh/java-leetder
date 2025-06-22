package neet_code.two_pointers;

public class _11_ContainerWithMostWater {
    public static void main(String[] args) {

    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = -1;

        while (left < right) {
            int leftVal = height[left];
            int rightVal = height[right];
            result = Math.max(Math.min(leftVal, rightVal) * (right - left), result);
            if (leftVal < rightVal) {
                left++;
            } else if (leftVal > rightVal) {
                right--;
            } else {
                left++;
                right--;
            }
        }

        return result;
    }
}
