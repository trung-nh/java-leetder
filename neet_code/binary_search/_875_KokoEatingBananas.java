package neet_code.binary_search;

import java.util.Arrays;

public class _875_KokoEatingBananas {
    public static void main(String[] args) {
        int result = minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6);
        System.out.println("result " + result);
    }

    // 4,11,20,23,30
    public static int minEatingSpeed(int[] piles, int h) {
        int min = 1, max = Arrays.stream(piles).max().getAsInt();
        int ans = max;

        while (min <= max) {
            int mid = min + (max - min) / 2;
            long hours = 0; // use long instead of int for case of overflow

            for (int pile : piles) {
                hours += (pile + mid - 1) / mid; // Ceiling division
            }

            if (hours <= h) {
                ans = mid;
                max = mid - 1; // Try smaller speed
            } else {
                min = mid + 1; // Need faster speed
            }
        }

        return ans;
    }

    public static int minEatingSpeed_(int[] piles, int h) {
        int n = piles.length;
        Arrays.sort(piles);

        if (h == n) {
            return piles[n - 1];
        }

        int right = n;
        int left = 0;
        int result = piles[n - 1];

        while (left < right) {
            int mid = (left + right) / 2;
            int neededHours = mid + 1;
            for (int i = n - 1; i > mid; i--) {
                neededHours += (int) Math.ceil((double) piles[i] / piles[mid]);
                if (neededHours > h) break;
            }

            if (neededHours > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int leftBound = left == 0 ? 0 : piles[left - 1];

        for (int i = piles[left]; i > leftBound; i--) {
            int neededHours = left;
            for (int j = n - 1; j >= left; j--) {
                neededHours += (int) Math.ceil((double) piles[j] / i);
                if (neededHours > h) break;
            }
            if (neededHours <= h) {
                result = Math.min(result, i);
            }
        }
        return result;
    }
}
