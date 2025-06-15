package daily._2025_06;

public class _2566_MaximumDifferenceByRemappingADigit {
    public static void main(String[] args) {
        int test = minMaxDifference(11891);
        System.out.println(test);
    }

    public static int minMaxDifference(int num) {
        String numString = String.valueOf(num);
        int n = numString.length();
        int replacedDigitForMin = (int) (num / Math.pow(10, n - 1));
        int replacedDigitForMax = -1;
        int difference = 0;
        for (int i = 0; i < n; i++) {
            int curCharDigit = numString.charAt(i) - '0';
            if (curCharDigit == replacedDigitForMin) {
                difference += (int) ((double) curCharDigit * Math.pow(10, n - i - 1));
            }

            if (curCharDigit == replacedDigitForMax) {
                difference += (int) ((double) (9 - curCharDigit) * Math.pow(10, n - i - 1));
            }

            if (curCharDigit == '9') continue;
            if (replacedDigitForMax == -1) {
                replacedDigitForMax = curCharDigit;
                difference += (int) ((double) (9 - curCharDigit) * Math.pow(10, n - i - 1));
            }
        }
        return difference;
    }
}
