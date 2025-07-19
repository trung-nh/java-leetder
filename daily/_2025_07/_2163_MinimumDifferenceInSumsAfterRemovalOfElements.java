package daily._2025_07;

import java.util.PriorityQueue;

public class _2163_MinimumDifferenceInSumsAfterRemovalOfElements {
    public static void main(String[] args) {
        minimumDifference(new int[]{6, 1, 99, 69, 11, 23, 15});
    }

    // Intuition: Choose k within [n,2n] such that the first k elements belong to the 1st partition
    // but only n of them are retained, and the last (3n-k) elements belong to the 2nd partition
    // but only n of them are retained also.
    // Target: Minimize the 1st partition and maximize the 2nd one
    public static long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        long sum = 0;
        long result = 0;
        long[] firstPartition = new long[n + 1];
        long secondPartition = 0;

        /*
            FIRST PARTITION
            using a max heap to remove (k-n) greatest elements from the 1st partition
        */
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // for k = n --> remove 0 element
        for (int i = 0; i < n; i++) {
            maxHeap.add(nums[i]);
            sum += nums[i];
        }
        firstPartition[0] = sum;

        // for k = [n+1, 2n]
        for (int i = n; i < 2 * n; i++) {
            maxHeap.add(nums[i]);
            sum += nums[i];
            sum -= maxHeap.poll();
            firstPartition[i - n + 1] = sum;
        }
        /*
            SECOND PARTITION
            using a min heap to remove (k-n) smallest elements from the 2nd partition
        */
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 3 * n - 1; i >= 2 * n; i--) {
            secondPartition += nums[i];
            minHeap.add(nums[i]);
        }

        result = firstPartition[n] - secondPartition;
        System.out.println(result);
        for (int i = 2 * n - 1; i >= n; i--) {
            minHeap.add(nums[i]);
            secondPartition += nums[i];
            secondPartition -= minHeap.poll();
            result = Math.min(result, firstPartition[i - n] - secondPartition);
        }
        return result;
    }
}
