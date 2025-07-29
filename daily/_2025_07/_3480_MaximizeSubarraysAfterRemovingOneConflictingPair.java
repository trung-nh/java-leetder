package daily._2025_07;

public class _3480_MaximizeSubarraysAfterRemovingOneConflictingPair {
    public static void main(String[] args) {
        System.out.println(subarrayCount(1,5));
        System.out.println(subarrayCount(0, (int) Math.pow(10,5)));
    }
    public static long maxSubarrays(int n, int[][] conflictingPairs) {
        int pairCount = conflictingPairs.length;
        long result = 0;



        return result;
    }

    private static long subarrayCount (int start, int end) {
        return (long) (end + start) * (end - start + 1) / 2;
    }
}
