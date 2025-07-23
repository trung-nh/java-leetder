package daily._2025_07;

public class _1717_MaximumScoreFromRemovingSubstrings {
    public static void main(String[] args) {

    }
    public int maximumGain(String s, int x, int y) {
        if (x >= y) return maximumGainHelper(s, 'a', 'b', x, y);
        else return maximumGainHelper(s, 'b', 'a', y, x);
    }

    private static int maximumGainHelper(String s, char a, int b, int x, int y) {
        int aCount = 0;
        int bCount = 0;
        int right = s.length() - 1;
        int result = 0;

        while (right >= 0) {
            if (s.charAt(right) == b) bCount++;
            else if (s.charAt(right) == a) {
                if (bCount > 0) {
                    bCount--;
                    result += x;
                } else aCount++;
            } else {
                result += Math.min(aCount, bCount) * y;
                aCount = 0;
                bCount = 0;
            }
            right--;
        }
        result += Math.min(aCount, bCount) * y;

        return result;
    }
}
